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

class SimonGameVM(
  private val navController: NavController,
  @SuppressLint("StaticFieldLeak") private val context: Context
) : ViewModel() {
  var level = mutableStateOf(1)
  var savedRecord = context.getSharedPreferences("record", Context.MODE_PRIVATE).getInt("record", 1)
  var record = mutableStateOf(savedRecord)
  var gameMode = GameMode.DEFAULTGAME

  private val soundList =
    arrayOf(Sounds.CAT_SOUND, Sounds.COW_SOUND, Sounds.FROG_SOUND, Sounds.PIG_SOUND)

  private val sequence = mutableListOf<Sounds>()
  private var playerSequence = mutableListOf<Sounds>()

  private val handler = HandlerCompat.createAsync(Looper.getMainLooper())

  fun getNavController(): NavController {
    return navController
  }

  fun getSoundListArray(): Array<Sounds> {
    return soundList
  }

  fun startGame(buttonText: String) {
    playerSequence.clear()
    if (buttonText != "Repeat") {
      if (level.value == 1) sequence.clear()
      val sound = soundList[(Math.random() * 4).toInt()]
      sequence.add(sound)
    }
    for (i in 0 until level.value) {
      playSound(sequence[i].soundId, i.toLong() * 1000)
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
    handler.postDelayed({
      mediaPlayer.start()
      mediaPlayer.setOnCompletionListener { mp ->
        mp.release()
      }
    }, timeMillis)
  }
}
