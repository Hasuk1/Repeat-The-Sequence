package com.example.repeat_the_sequence.ui.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repeat_the_sequence.R
import com.example.repeat_the_sequence.enums.Sounds

@Composable
fun SquareButton(
  buttonOfSound: Sounds,
  isBlocked: MutableState<Boolean>,
  onClick: () -> Unit
) {
  val blockedColorFilter = ColorFilter.lighting(Color.DarkGray, Color.DarkGray)
  val myColorFilter = if (isBlocked.value) blockedColorFilter else null

  Box(modifier = Modifier
    .padding(5.dp)
    .width(110.dp)
    .height(110.dp)
    .clickable {
      if (!isBlocked.value) onClick.invoke()
    }) {
    Image(
      painter = painterResource(id = R.drawable.game_button),
      contentDescription = "${buttonOfSound.soundName}_button",
      modifier = Modifier.fillMaxSize(),
      colorFilter = myColorFilter
    )
    Text(
      text = buttonOfSound.emoji, fontSize = 35.sp, modifier = Modifier.align(Alignment.Center)
    )
  }
}