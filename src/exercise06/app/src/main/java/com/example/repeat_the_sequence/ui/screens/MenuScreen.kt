package com.example.repeat_the_sequence.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import com.example.repeat_the_sequence.enums.AppScreens
import com.example.repeat_the_sequence.ui.components.buttons.RectangleButton
import com.example.repeat_the_sequence.ui.elements.GameLogo

@Composable
fun MenuScreen(navController: NavHostController) {
  Column(
    Modifier
      .fillMaxSize()
      .padding(10.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top
  ) {
    GameLogo()
    RectangleButton("Play") {
      navController.navigate(
        AppScreens.GAME.route, navOptions = NavOptions.Builder().setLaunchSingleTop(true).build()
      )
    }
    RectangleButton("Free game") {
      navController.navigate(
        AppScreens.FREEGAME.route,
        navOptions = NavOptions.Builder().setLaunchSingleTop(true).build()
      )
    }
    RectangleButton("Settings") {
      navController.navigate(
        AppScreens.SETTINGS.route,
        navOptions = NavOptions.Builder().setLaunchSingleTop(true).build()
      )
    }
    RectangleButton("About") {
      navController.navigate(
        AppScreens.ABOUT.route, navOptions = NavOptions.Builder().setLaunchSingleTop(true).build()
      )
    }
  }
}
