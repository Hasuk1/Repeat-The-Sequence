package com.example.repeat_the_sequence.ui.components.information

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repeat_the_sequence.R
import com.example.repeat_the_sequence.ui.types.stardewValleyFont

@Composable
fun CopyrightCard(name: String) {
  Box(
    Modifier
      .padding(vertical = 5.dp)
      .width(350.dp)
      .height(70.dp),
    contentAlignment = Alignment.Center
  ) {
    Image(
      painterResource(R.drawable.game_info), "game_info", Modifier.fillMaxSize()
    )
    Text(
      text = "Copyright (c) 2024 $name",
      color = Color.White,
      fontSize = 32.sp,
      fontFamily = stardewValleyFont,
    )
  }
}