package com.example.repeat_the_sequence.ui.components.information

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repeat_the_sequence.R
import com.example.repeat_the_sequence.ui.types.stardewValleyFont
import com.example.repeat_the_sequence.viewmodel.SimonGameVM

@Composable
fun LoseInfo(vm: SimonGameVM) {
  @Composable
  fun LoseTitle() {
    @Composable
    fun TitleText(_text: String) {
      Text(
        text = _text,
        color = Color.White,
        fontSize = 68.sp,
        fontFamily = stardewValleyFont,
        fontWeight = FontWeight.Normal,
      )
    }
    Column(
      Modifier.size(width = 272.dp, height = 136.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Spacer(Modifier.weight(1f))
      TitleText("YOU")
      TitleText("LOSE")
      Spacer(Modifier.weight(1f))
    }
  }

  @Composable
  fun GameResult(_text: String) {
    Column(
      Modifier.size(width = 272.dp, height = 58.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Spacer(Modifier.weight(1f))
      Text(
        text = _text,
        color = Color.White,
        fontSize = 40.sp,
        fontFamily = stardewValleyFont,
        fontWeight = FontWeight.Normal,
      )
      Spacer(Modifier.weight(1f))
    }
  }

  val resultText = if (vm.record.value > vm.savedRecord) "New record" else "Record"
  Box(
    Modifier
      .width(272.dp)
      .height(272.dp)
  ) {
    Image(
      painterResource(R.drawable.lose_window), "lose_window", Modifier.fillMaxSize()
    )
    Column(
      Modifier
        .fillMaxSize()
        .padding(10.dp)
    ) {
      LoseTitle()
      GameResult("Result: ${vm.level.value}")
      GameResult("$resultText: ${vm.record.value}")
    }
  }
}