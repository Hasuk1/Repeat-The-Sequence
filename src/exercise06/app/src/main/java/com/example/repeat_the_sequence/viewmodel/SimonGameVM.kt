package com.example.repeat_the_sequence.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaPlayer
import android.os.Looper
import android.util.Log
import androidx.compose.runtime.MutableState
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
  var level = mutableStateOf(1)
  var savedRecord = context.getSharedPreferences("record", Context.MODE_PRIVATE).getInt("record", 1)
  var record = mutableStateOf(savedRecord)
  var gameMode = GameMode.DEFAULTGAME
  private var isSoundEnabledSaved = mutableStateOf(
    context.getSharedPreferences("is_sound_enabled", Context.MODE_PRIVATE)
      .getBoolean("is_sound_enabled", true)
  )
  private var soundDelaySaved = mutableStateOf(
    context.getSharedPreferences("sound_delay", Context.MODE_PRIVATE).getLong("sound_delay", 1000)
  )
  private var isButtonBacklightEnabledSaved = mutableStateOf(
    context.getSharedPreferences("button_backlight", Context.MODE_PRIVATE)
      .getBoolean("button_backlight", true)
  )
  private val soundListSaved = mutableStateOf(
    context.getSharedPreferences("sound_list_tag", Context.MODE_PRIVATE)
      .getString("sound_list_tag", "animal")
  )

  private val soundList = when (soundListSaved.value) {
    "animal" -> animalSound
    "sms" -> smsSound
    else -> animalSound
  }

  private val sequence = mutableListOf<Sounds>()
  private var playerSequence = mutableListOf<Sounds>()

  private val handler = HandlerCompat.createAsync(Looper.getMainLooper())

  fun getNavController(): NavController {
    return navController
  }

  fun getSoundEnabledStatus(): MutableState<Boolean> {
    return isSoundEnabledSaved
  }

  fun getSoundDelaySec(): MutableState<Long> {
    return mutableStateOf(soundDelaySaved.value / 100)
  }

  fun getButtonBacklightStatus(): MutableState<Boolean> {
    return isButtonBacklightEnabledSaved
  }

  fun getSoundListName(): MutableState<String?> {
    return soundListSaved
  }

  fun getSoundListArray(): Array<Sounds> {
    return soundList
  }

  fun setSoundEnabledStatus(newStatus: Boolean) {
    isSoundEnabledSaved.value = newStatus
    context.getSharedPreferences("is_sound_enabled", Context.MODE_PRIVATE).edit()
      .putBoolean("is_sound_enabled", newStatus).apply()
  }

  fun setSoundDelay(newDelay: Long) {
    soundDelaySaved.value = newDelay
    context.getSharedPreferences("sound_delay", Context.MODE_PRIVATE).edit()
      .putLong("sound_delay", newDelay).apply()
  }

  fun setButtonBacklightStatus(newStatus: Boolean) {
    isButtonBacklightEnabledSaved.value = newStatus
    context.getSharedPreferences("button_backlight", Context.MODE_PRIVATE).edit()
      .putBoolean("button_backlight", newStatus).apply()
  }

  fun setSoundList(newList: String) {
    soundListSaved.value = newList
    context.getSharedPreferences("sound_list_tag", Context.MODE_PRIVATE).edit()
      .putString("sound_list_tag", newList).apply()
  }

  fun startGame(buttonText: String) {
    playerSequence.clear()
    if (buttonText != "Repeat") {
      if (level.value == 1) sequence.clear()
      val sound = soundList[(Math.random() * 4).toInt()]
      sequence.add(sound)
    }
    for (i in 0 until level.value) {
      playSound(sequence[i].soundId, i.toLong() * soundDelaySaved.value)
      Log.d("MyLog", "soundName: ${sequence[i].soundName}")
    }
    Log.d("MyLog", "========================")
  }

  fun endGame() {
    playerSequence.clear()
    sequence.clear()
    level.value = 1
  }

  fun addPlayerSequence(sound: Sounds) {
    playSound(sound.soundId, 0)
    if (gameMode == GameMode.DEFAULTGAME) {
      playerSequence.add(sound)
      checkResult()
    }
  }

  private fun checkResult() {
    var result = true
    for (i in 0 until playerSequence.size) {
      if (playerSequence[i] == sequence[i]) {
        continue
      } else {
        result = false
      }
    }
    if (playerSequence.size == sequence.size && result) {
      level.value++
      if (level.value > record.value + 1) {
        record.value = level.value - 1
        context.getSharedPreferences("record", Context.MODE_PRIVATE).edit()
          .putInt("record", record.value).apply()
      }
    } else if (!result) {
      navController.navigate(AppScreens.LOSE.route) {
        popUpTo(AppScreens.GAME.route) {
          inclusive = true
        }
      }
    }
  }

  private fun playSound(sound: Int, timeMillis: Long) {
    val mediaPlayer = MediaPlayer.create(context, sound)
    val volume = if (isSoundEnabledSaved.value) 1f else 0f
    handler.postDelayed({
      mediaPlayer.start()
      mediaPlayer.setOnCompletionListener { mp ->
        mp.release()
      }
      mediaPlayer.setVolume(volume, volume)
    }, timeMillis)
  }
}
