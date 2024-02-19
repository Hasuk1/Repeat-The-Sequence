package com.example.repeat_the_sequence.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.repeat_the_sequence.enums.AppScreens
import com.example.repeat_the_sequence.enums.GameMode
import com.example.repeat_the_sequence.ui.components.buttons.BackArrowButton
import com.example.repeat_the_sequence.ui.components.buttons.RectangleButton
import com.example.repeat_the_sequence.ui.components.buttons.SquareButton
import com.example.repeat_the_sequence.ui.components.information.GameInfo
import com.example.repeat_the_sequence.ui.components.information.GameInvitation
import com.example.repeat_the_sequence.ui.elements.GameLogo
import com.example.repeat_the_sequence.viewmodel.SimonGameVM
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun GameScreen(viewModel: SimonGameVM) {
  val lvl = remember { viewModel.level }
  val record = remember { viewModel.record }
  val invitation = remember { mutableStateOf("") }
  val playButtonText = remember { mutableStateOf("play") }
  val isSoundButtonBlocked = remember { mutableStateOf(viewModel.gameMode == GameMode.DEFAULTGAME) }
  val coroutineScope = rememberCoroutineScope()

  val soundList = viewModel.getSoundListArray()

  Column(
    Modifier
      .fillMaxSize()
      .padding(10.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .height(30.dp),
      horizontalAlignment = Alignment.Start,
    ) {
      BackArrowButton(description = "back_arrow_menu") {
        viewModel.endGame()
        viewModel.getNavController().navigate(AppScreens.MENU.route) {
          popUpTo(AppScreens.MENU.route) {
            inclusive = true
          }
        }
      }
    }
    if (viewModel.gameMode == GameMode.FREEGAME) {
      GameLogo()
    } else {
      GameInfo("level", lvl)
      GameInfo("record", record)
    }
    GameInvitation(lvl, invitation, playButtonText, isSoundButtonBlocked)
    Row {
      SquareButton(soundList[0], isSoundButtonBlocked, viewModel.getButtonBacklightStatus()) {
        viewModel.addPlayerSequence(soundList[0])
      }
      SquareButton(soundList[1], isSoundButtonBlocked, viewModel.getButtonBacklightStatus()) {
        viewModel.addPlayerSequence(soundList[1])
      }
    }
    Row {
      SquareButton(soundList[2], isSoundButtonBlocked, viewModel.getButtonBacklightStatus()) {
        viewModel.addPlayerSequence(soundList[2])
      }
      SquareButton(soundList[3], isSoundButtonBlocked, viewModel.getButtonBacklightStatus()) {
        viewModel.addPlayerSequence(soundList[3])
      }
    }
    Spacer(modifier = Modifier.weight(1f))
    if (viewModel.gameMode == GameMode.DEFAULTGAME) RectangleButton(playButtonText.value) {
      isSoundButtonBlocked.value = true
      invitation.value = "Listen carefully"
      viewModel.startGame(playButtonText.value)
      coroutineScope.launch {
        delay(viewModel.getSoundDelaySec().value * lvl.value.toLong())
        isSoundButtonBlocked.value = false
        invitation.value = "It's your turn"
      }
    }
  }
}