package com.example.repeat_the_sequence.ui.components.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.repeat_the_sequence.R

@Composable
fun BackgroundImage() {
  Image(
    painter = painterResource(id = R.drawable.menu_background),
    contentDescription = "menu_background",
    contentScale = ContentScale.Crop,
    modifier = Modifier
      .fillMaxSize()
      .blur(2.dp, 2.dp)
      .alpha(0.85F)
  )
}