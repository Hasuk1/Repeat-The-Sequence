package com.example.repeat_the_sequence.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.repeat_the_sequence.enums.AppScreens
import com.example.repeat_the_sequence.ui.components.buttons.BackArrowButton
import com.example.repeat_the_sequence.ui.components.images.BackgroundImage
import com.example.repeat_the_sequence.ui.components.information.CopyrightCard
import com.example.repeat_the_sequence.ui.components.information.GameConditionsCard
import com.example.repeat_the_sequence.ui.components.information.GameSettingsCard
import com.example.repeat_the_sequence.ui.components.information.RecordCard
import com.example.repeat_the_sequence.viewmodel.SimonGameVM

@Composable
fun AboutAppScreen(vm: SimonGameVM) {
  BackgroundImage()
  Row(
    modifier = Modifier
      .padding(10.dp)
      .fillMaxWidth()
  ) {
    BackArrowButton(description = "back_to_menu") {
      vm.getNavController().navigate(AppScreens.MENU.route) {
        popUpTo(AppScreens.ABOUT.route) { inclusive = true }
        vm.endGame()
      }
    }
  }
  Column(
    Modifier
      .fillMaxSize()
      .padding(10.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    RecordCard(vm.record.value)
    GameConditionsCard()
    GameSettingsCard(
      isSoundEnable = vm.getSoundEnabledStatus().value,
      isButtonBacklightEnabled = vm.getButtonBacklightStatus().value,
      soundDelay = vm.getSoundDelaySec().value,
      soundTheme = vm.getSoundListName().value!!
    )
    CopyrightCard("Hasuk1")
  }
}
