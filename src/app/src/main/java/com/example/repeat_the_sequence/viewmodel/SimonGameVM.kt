package com.example.repeat_the_sequence.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaPlayer
import android.os.Looper
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.core.os.HandlerCompat
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.repeat_the_sequence.enums.AppScreens
import com.example.repeat_the_sequence.enums.GameMode
import com.example.repeat_the_sequence.enums.Sounds
import com.example.repeat_the_sequence.utility.SoundThemeList.animalSound
import com.example.repeat_the_sequence.utility.SoundThemeList.smsSound

class SimonGameVM(
  private val navController: NavController,
  @SuppressLint("StaticFieldLeak") private val context: Context
) : ViewModel() {
  var gameMode = GameMode.DEFAULTGAME
  var level = mutableStateOf(1)

  var record =
    mutableStateOf(context.getSharedPreferences("record", Context.MODE_PRIVATE).getInt("record", 1))
    set(value) {
      field = value
      context.getSharedPreferences("record", Context.MODE_PRIVATE).edit()
        .putInt("record", field.value).apply()
    }

  var isSoundEnabled = mutableStateOf(
    context.getSharedPreferences("is_sound_enabled", Context.MODE_PRIVATE)
      .getBoolean("is_sound_enabled", true)
  )
    set(value) {
      field = value
      context.getSharedPreferences("is_sound_enabled", Context.MODE_PRIVATE).edit()
        .putBoolean("is_sound_enabled", field.value).apply()
    }

  var soundDelay = mutableStateOf(
    context.getSharedPreferences("sound_delay", Context.MODE_PRIVATE).getLong("sound_delay", 1000)
  )
    get() = mutableStateOf(field.value)
    set(value) {
      field = value
      context.getSharedPreferences("sound_delay", Context.MODE_PRIVATE).edit()
        .putLong("sound_delay", field.value).apply()
    }

  var isButtonBacklightEnabled = mutableStateOf(
    context.getSharedPreferences("button_backlight", Context.MODE_PRIVATE)
      .getBoolean("button_backlight", true)
  )
    set(value) {
      field = value
      context.getSharedPreferences("button_backlight", Context.MODE_PRIVATE).edit()
        .putBoolean("button_backlight", field.value).apply()
    }

  private var soundList = animalSound

  var soundListName = mutableStateOf(
    context.getSharedPreferences("sound_list_name", Context.MODE_PRIVATE)
      .getString("sound_list_name", "animal")
  )
    set(value) {
      field = value
      context.getSharedPreferences("sound_list_name", Context.MODE_PRIVATE).edit()
        .putString("sound_list_name", value.value).apply()

      soundList = when (field.value) {
        "animal" -> animalSound
        "sms" -> smsSound
        else -> animalSound
      }
    }

  fun getSoundList(): Array<Sounds> {
    return when (soundListName.value) {
      "animal" -> animalSound
      "sms" -> smsSound
      else -> animalSound
    }
  }

  private val sequence = mutableListOf<Sounds>()
  private var playerSequence = mutableListOf<Sounds>()

  private val handler = HandlerCompat.createAsync(Looper.getMainLooper())

  fun getNavController(): NavController {
    return navController
  }

  fun startGame(buttonText: String) {
    playerSequence.clear()
    if (buttonText != "Repeat") {
      if (level.value == 1) sequence.clear()
      val sound = soundList[(Math.random() * 4).toInt()]
      sequence.add(sound)
    }
    for (i in 0 until level.value) {
      playSound(sequence[i].soundId, i.toLong() * soundDelay.value)
      Log.d("GameSeq", "soundName: ${sequence[i].soundName}")
    }
    Log.d("GameSeq", "========================")
  }

  fun endGame() {
    playerSequence.clear()
    sequence.clear()
    level.value = 1
  }

  fun addPlayerSequence(sound: Sounds) {
    if (gameMode == GameMode.DEFAULTGAME) {
      playerSequence.add(sound)
      checkResult(sound.soundId)
    } else {
      playSound(sound.soundId, 0)
    }
  }

  private fun checkResult(sound: Int) {
    var result = true
    for (i in 0 until playerSequence.size) {
      if (playerSequence[i] == sequence[i]) {
        continue
      } else {
        result = false
      }
    }
    if (result) playSound(sound, 0)
    if (playerSequence.size == sequence.size && result) {
      level.value++
      if (level.value > record.value + 1) {
        record.value = level.value - 1
        record = mutableStateOf(level.value - 1)
      }
    } else if (!result) {
      playSound(Sounds.LOSE_SOUND.soundId, 0)
      navController.navigate(AppScreens.LOSE.route) {
        popUpTo(AppScreens.GAME.route) {
          inclusive = true
        }
      }
    }
  }

  private fun playSound(sound: Int, timeMillis: Long) {
    val mediaPlayer = MediaPlayer.create(context, sound)
    val volume = if (isSoundEnabled.value) 1f else 0f
    Log.d("GameDelay", "playSound - GameDelay => ${soundDelay.value}")
    handler.postDelayed({
      mediaPlayer.start()
      mediaPlayer.setOnCompletionListener { mp ->
        mp.release()
      }
      mediaPlayer.setVolume(volume, volume)
    }, timeMillis)
  }
}
