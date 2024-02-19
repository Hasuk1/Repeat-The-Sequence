package com.example.repeat_the_sequence

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.repeat_the_sequence.enums.AppScreens
import com.example.repeat_the_sequence.ui.components.images.BackgroundImage
import com.example.repeat_the_sequence.ui.screens.GameScreen
import com.example.repeat_the_sequence.ui.screens.LoseScreen
import com.example.repeat_the_sequence.viewmodel.SimonGameVM

class MainActivity : ComponentActivity() {
  @SuppressLint("SourceLockedOrientationActivity")
  override fun onCreate(savedInstanceState: Bundle?) {
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    super.onCreate(savedInstanceState)
    setContent {
      BackgroundImage()
      val navController = rememberNavController()
      val vm = SimonGameVM(navController, this@MainActivity)
      NavHost(navController = navController, startDestination = AppScreens.GAME.route) {
        composable(AppScreens.GAME.route) {
          GameScreen(vm)
        }
        composable(AppScreens.LOSE.route) {
          LoseScreen(vm)
        }
      }
    }
  }
}
