package com.example.repeat_the_sequence.ui.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
fun RectangleButton(buttonText: String, onClick: () -> Unit) {
  Box(modifier = Modifier
    .padding(bottom = 20.dp)
    .width(272.dp)
    .height(60.dp)
    .shadow(8.dp, RoundedCornerShape(8.dp), false)
    .clickable {
      if (buttonText != "...") onClick.invoke()
    }) {
    Image(
      painter = painterResource(id = R.drawable.button),
      contentDescription = buttonText.lowercase().replace(" ", "_"),
      modifier = Modifier.fillMaxSize()
    )
    Text(
      text = buttonText.uppercase(),
      color = Color.White,
      fontSize = 48.sp,
      fontFamily = stardewValleyFont,
      fontWeight = FontWeight.Normal,
      modifier = Modifier.align(Alignment.Center)
    )
  }
}