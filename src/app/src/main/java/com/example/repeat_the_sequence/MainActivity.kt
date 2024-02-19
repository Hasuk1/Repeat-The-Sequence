package com.example.repeat_the_sequence

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.repeat_the_sequence.enums.AppScreens
import com.example.repeat_the_sequence.nav.MyNavHost
import com.example.repeat_the_sequence.ui.components.images.BackgroundImage
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
      MyNavHost(navController, AppScreens.MENU.route, vm)
    }
  }
}
