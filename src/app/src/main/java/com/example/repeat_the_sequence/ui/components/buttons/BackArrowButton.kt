package com.example.repeat_the_sequence.ui.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.repeat_the_sequence.R

@Composable
fun BackArrowButton(description: String, onClick: () -> Unit) {
  Box(modifier = Modifier
    .width(33.dp)
    .height(30.dp)
    .clickable {
      onClick.invoke()
    }) {
    Image(
      painter = painterResource(id = R.drawable.back_arrow),
      contentDescription = description,
      modifier = Modifier.fillMaxSize()
    )
  }
}