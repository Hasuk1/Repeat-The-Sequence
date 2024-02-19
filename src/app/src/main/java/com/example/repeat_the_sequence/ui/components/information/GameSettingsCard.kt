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
fun GameSettingsCard(
  isSoundEnable: Boolean,
  isButtonBacklightEnabled: Boolean,
  soundDelay: Long,
  soundTheme: String
) {
  fun getSwitchStatus(switchStatus: Boolean): String {
    return if (switchStatus) "on" else "off"
  }
  Box(
    Modifier
      .padding(vertical = 5.dp)
      .width(350.dp)
      .height(160.dp),
    contentAlignment = Alignment.Center
  ) {
    Image(
      painterResource(R.drawable.combo_box), "combo_box", Modifier.fillMaxSize()
    )
    Column(
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        text = "Game settings.",
        color = Color.White,
        fontSize = 30.sp,
        fontFamily = stardewValleyFont,
      )

      Text(
        text = "Button backlight: ${getSwitchStatus(isButtonBacklightEnabled)}",
        color = Color.White,
        fontSize = 24.sp,
        fontFamily = stardewValleyFont,
      )
      Text(
        text = "Sound: ${getSwitchStatus(isSoundEnable)}",
        color = Color.White,
        fontSize = 24.sp,
        fontFamily = stardewValleyFont,
      )
      Text(
        text = "Delay: ${soundDelay.toDouble() / 10} s",
        color = Color.White,
        fontSize = 24.sp,
        fontFamily = stardewValleyFont,
      )
      Text(
        text = "Sound theme: $soundTheme",
        color = Color.White,
        fontSize = 24.sp,
        fontFamily = stardewValleyFont,
      )
    }
  }
}