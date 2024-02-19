package com.example.repeat_the_sequence.ui.components.switches

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
fun SoundEnabledSwitch(info: String, vm: SimonGameVM) {
  var checked by remember { vm.getSoundEnabledStatus() }
  fun getBackColor(): Color {
    return if (checked) {
      LightGreen
    } else {
      Color.White
    }
  }
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
        text = info,
        color = Color.White,
        fontSize = 30.sp,
        fontFamily = stardewValleyFont,
        fontWeight = FontWeight.Normal,
        modifier = Modifier
          .padding(horizontal = 5.dp)
          .weight(1f)
      )
      var colorBack by remember { mutableStateOf(getBackColor()) }
      Card(
        modifier = Modifier
          .padding(horizontal = 5.dp)
          .size(width = 45.dp, height = 25.dp),
        backgroundColor = colorBack,
        shape = RoundedCornerShape(10.dp)
      ) {
        Switch(
          checked = checked, onCheckedChange = {
            checked = it
            vm.setSoundEnabledStatus(it)
            colorBack = getBackColor()
          }, colors = SwitchDefaults.colors(
            uncheckedTrackAlpha = 1f,
            uncheckedThumbColor = LightGreen,
            uncheckedTrackColor = Color.White,
            checkedTrackAlpha = 1f,
            checkedThumbColor = DarkGreen,
            checkedTrackColor = LightGreen
          )
        )
      }
    }
  }
}