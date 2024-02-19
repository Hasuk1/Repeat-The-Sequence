package com.example.repeat_the_sequence.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.repeat_the_sequence.R

@Composable
fun GameLogo() {
  Image(
    painter = painterResource(id = R.drawable.game_logo),
    contentDescription = "game_logo",
    modifier = Modifier
      .padding(vertical = 20.dp)
      .width(390.dp)
      .height(220.dp)
  )
}