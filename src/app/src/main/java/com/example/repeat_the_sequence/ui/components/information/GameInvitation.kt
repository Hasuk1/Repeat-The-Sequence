package com.example.repeat_the_sequence.ui.components.information

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repeat_the_sequence.ui.types.stardewValleyFont

@Composable
fun GameInvitation(
  lvl: MutableState<Int>,
  invitation: MutableState<String>,
  playButtonText: MutableState<String>,
  isSoundButtonBlocked: MutableState<Boolean>
) {
  LaunchedEffect(lvl.value) {
    if (lvl.value > 1) invitation.value = "That's right!"
  }
  LaunchedEffect(invitation.value) {
    when (invitation.value) {
      "That's right!" -> {
        playButtonText.value = "next level"
        isSoundButtonBlocked.value = true
      }
      "Listen carefully" -> playButtonText.value = "..."
      "It's your turn" -> playButtonText.value = "Repeat"
    }
  }
  Text(
    text = invitation.value,
    style = TextStyle(shadow = Shadow(Color.Black, Offset(8f, 8f), 16f)),
    color = Color.White,
    fontSize = 40.sp,
    fontFamily = stardewValleyFont,
    fontWeight = FontWeight.Normal,
    modifier = Modifier.padding(vertical = 20.dp)
  )
}