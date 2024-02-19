package com.example.repeat_the_sequence.ui.components.information

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repeat_the_sequence.R
import com.example.repeat_the_sequence.ui.types.stardewValleyFont

@Composable
fun GameInfo(info: String, lvl: MutableState<Int>) {
  Box(
    modifier = Modifier
      .padding(5.dp)
      .width(300.dp)
      .height(70.dp)
      .shadow(8.dp, RoundedCornerShape(8.dp), false)
  ) {
    Image(
      painter = painterResource(id = R.drawable.game_info),
      contentDescription = "${info}_info",
      modifier = Modifier.fillMaxSize()
    )
    Text(
      text = "${info.uppercase()}: ${lvl.value}",
      color = Color.White,
      fontSize = 30.sp,
      fontFamily = stardewValleyFont,
      fontWeight = FontWeight.Normal,
      modifier = Modifier.align(Alignment.Center)
    )
  }
}