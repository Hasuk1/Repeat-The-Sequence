package com.example.repeat_the_sequence.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.repeat_the_sequence.enums.AppScreens
import com.example.repeat_the_sequence.ui.components.buttons.RectangleButton
import com.example.repeat_the_sequence.ui.components.information.LoseInfo
import com.example.repeat_the_sequence.viewmodel.SimonGameVM

@Composable
fun LoseScreen(vm: SimonGameVM) {
  Column(
    Modifier
      .padding(10.dp)
      .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Spacer(Modifier.fillMaxSize(0.2F))
    LoseInfo(vm)
    Spacer(Modifier.size(20.dp))
    RectangleButton("try again") {
      vm.getNavController().navigate(AppScreens.GAME.route) {
        popUpTo(AppScreens.LOSE.route) { inclusive = true }
        vm.endGame()
      }
    }
    RectangleButton("menu") {
      vm.getNavController().navigate(AppScreens.MENU.route) {
        popUpTo(AppScreens.LOSE.route) { inclusive = true }
        vm.endGame()
      }
    }
  }
}