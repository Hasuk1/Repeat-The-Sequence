package com.example.repeat_the_sequence.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.repeat_the_sequence.enums.AppScreens
import com.example.repeat_the_sequence.enums.GameMode
import com.example.repeat_the_sequence.ui.screens.*
import com.example.repeat_the_sequence.viewmodel.SimonGameVM

@Composable
fun MyNavHost(navController: NavHostController, startRoute: String, vm: SimonGameVM) {
  NavHost(navController = navController, startDestination = startRoute) {
    composable(AppScreens.MENU.route) {
      MenuScreen(navController)
    }
    composable(AppScreens.GAME.route) {
      vm.gameMode = GameMode.DEFAULTGAME
      GameScreen(vm)
    }
    composable(AppScreens.FREEGAME.route) {
      vm.gameMode = GameMode.FREEGAME
      GameScreen(vm)
    }
    composable(AppScreens.LOSE.route) {
      LoseScreen(vm)
    }
    composable(AppScreens.SETTINGS.route) {
      GameSettingsScreen(vm)
    }
    composable(AppScreens.ABOUT.route) {
      AboutAppScreen(vm)
    }
  }
}