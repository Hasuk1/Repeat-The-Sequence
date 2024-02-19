package com.example.repeat_the_sequence.ui.components.sliders

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repeat_the_sequence.R
import com.example.repeat_the_sequence.ui.theme.DarkGreen
import com.example.repeat_the_sequence.ui.theme.LightGreen
import com.example.repeat_the_sequence.ui.types.stardewValleyFont
import com.example.repeat_the_sequence.viewmodel.SimonGameVM

@Composable
fun SoundDelaySlider(info: String, vm: SimonGameVM) {
  var sliderPosition by remember { vm.getSoundDelaySec() }
  Box(
    modifier = Modifier
      .padding(5.dp)
      .width(350.dp)
      .height(70.dp)
  ) {
    Image(
      painter = painterResource(id = R.drawable.game_info),
      contentDescription = "${info}_info",
      modifier = Modifier.fillMaxSize()
    )
    Row(
      modifier = Modifier
        .padding(15.dp)
        .fillMaxSize(),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "$info: ${sliderPosition.toDouble() / 10} s",
        color = Color.White,
        fontSize = 30.sp,
        fontFamily = stardewValleyFont,
        fontWeight = FontWeight.Normal,
        modifier = Modifier
          .padding(horizontal = 5.dp)
          .weight(1f)
      )

      Box(
        modifier = Modifier
          .padding(horizontal = 5.dp)
          .size(width = 165.dp, height = 25.dp)
      ) {
        Slider(
          value = sliderPosition.toFloat(), onValueChange = {
            sliderPosition = it.toLong()
            vm.setSoundDelay((it * 100).toLong())
          }, colors = SliderDefaults.colors(
            thumbColor = DarkGreen, activeTrackColor = LightGreen
          ), steps = 8, valueRange = 1f..10f
        )
      }
    }
  }
}