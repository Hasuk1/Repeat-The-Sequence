package com.example.repeat_the_sequence.ui.components.information

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repeat_the_sequence.R
import com.example.repeat_the_sequence.ui.types.stardewValleyFont

@Composable
fun GameConditionsCard() {
  Box(
    Modifier
      .padding(vertical = 5.dp)
      .width(350.dp)
      .height(180.dp),
    contentAlignment = Alignment.Center
  ) {
    Image(
      painterResource(R.drawable.game_conditions), "game_conditions", Modifier.fillMaxSize()
    )
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        text = "Game conditions!",
        color = Color.White,
        fontSize = 30.sp,
        fontFamily = stardewValleyFont,
      )
      Text(
        text = "You need to repeat a sequence of sounds. Each successful level increases the length of the sequence. If you make a mistake, the game ends.",
        color = Color.White,
        fontSize = 24.sp,
        softWrap = true,
        textAlign = TextAlign.Center,
        fontFamily = stardewValleyFont,
      )
    }
  }
}