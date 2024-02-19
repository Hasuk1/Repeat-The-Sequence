package com.example.repeat_the_sequence.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.repeat_the_sequence.enums.AppScreens
import com.example.repeat_the_sequence.ui.components.buttons.BackArrowButton
import com.example.repeat_the_sequence.ui.components.combobox.SoundListBox
import com.example.repeat_the_sequence.ui.components.sliders.SoundDelaySlider
import com.example.repeat_the_sequence.ui.components.switches.ButtonBacklightSwitch
import com.example.repeat_the_sequence.ui.components.switches.SoundEnabledSwitch
import com.example.repeat_the_sequence.viewmodel.SimonGameVM

@Composable
fun GameSettingsScreen(vm: SimonGameVM) {
  Row(
    modifier = Modifier
      .padding(10.dp)
      .fillMaxWidth()
  ) {
    BackArrowButton(description = "back_to_menu") {
      vm.getNavController().navigate(AppScreens.MENU.route) {
        popUpTo(AppScreens.SETTINGS.route) { inclusive = true }
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
    ButtonBacklightSwitch("Button backlight", vm)
    SoundEnabledSwitch("Sound", vm)
    SoundDelaySlider("Delay", vm)
    SoundListBox("Sound theme", vm)
  }
}