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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repeat_the_sequence.R
import com.example.repeat_the_sequence.ui.types.stardewValleyFont
import com.example.repeat_the_sequence.viewmodel.SimonGameVM

@Composable
fun LoseInfo(vm: SimonGameVM) {
  @Composable
  fun LoseTitle() {
    Column(
      Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.54f),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        text = "YOU\nLOSE",
        color = Color.White,
        fontSize = 68.sp,
        textAlign = TextAlign.Center,
        fontFamily = stardewValleyFont,
        fontWeight = FontWeight.Normal,
      )
    }
  }

  @Composable
  fun GameResult(_text: String, fraction: Float = 1f) {
    Column(
      Modifier
        .fillMaxWidth()
        .fillMaxHeight(fraction),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        text = _text,
        color = Color.White,
        fontSize = 40.sp,
        fontFamily = stardewValleyFont,
        fontWeight = FontWeight.Normal,
      )
    }
  }

  val resultText = if (vm.record.value > vm.record.value) "New record" else "Record"
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
      GameResult("Result: ${vm.level.value}", 0.49f)
      GameResult("$resultText: ${vm.record.value}")
    }
  }
}