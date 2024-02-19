package com.example.repeat_the_sequence.ui.types

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.repeat_the_sequence.R

val Typography = Typography(
  body1 = TextStyle(
    fontFamily = FontFamily.Default, fontWeight = FontWeight.Normal, fontSize = 16.sp
  )
)

val stardewValleyFont = FontFamily(Font(R.font.stardew_valley, FontWeight.Normal))