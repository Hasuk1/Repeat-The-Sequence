package com.example.repeat_the_sequence.ui.components.combobox

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
fun SoundListBox(info: String = "", vm: SimonGameVM) {
  fun getBackColor(status: Boolean): Color {
    return if (status) {
      LightGreen
    } else {
      Color.White
    }
  }

  fun getChecked(listName: String?, listTag: String): Boolean {
    return listName == listTag
  }

  val currentSoundList by remember { vm.getSoundListName() }
  var checkedAnimal by remember { mutableStateOf(getChecked(currentSoundList, "animal")) }
  var checkedSms by remember { mutableStateOf(getChecked(currentSoundList, "sms")) }
  var colorBackAnimal by remember { mutableStateOf(getBackColor(checkedAnimal)) }
  var colorBackSms by remember { mutableStateOf(getBackColor(checkedSms)) }

  Box(
    modifier = Modifier
      .padding(5.dp)
      .width(350.dp)
      .height(160.dp)
  ) {
    Image(
      painter = painterResource(id = R.drawable.combo_box),
      contentDescription = "${info}_info",
      modifier = Modifier.fillMaxSize()
    )
    Column(
      modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()
    ) {
      Row(
        modifier = Modifier
          .weight(1f)
          .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = "$info: ",
          color = Color.White,
          fontSize = 30.sp,
          fontFamily = stardewValleyFont,
          fontWeight = FontWeight.Normal,
          modifier = Modifier.padding(horizontal = 5.dp)
        )
      }
      Row(
        modifier = Modifier
          .weight(1f)
          .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = "  Animal ",
          color = Color.White,
          fontSize = 30.sp,
          fontFamily = stardewValleyFont,
          fontWeight = FontWeight.Normal,
          modifier = Modifier
            .padding(horizontal = 5.dp)
            .weight(1f)
        )

        Card(
          modifier = Modifier
            .padding(horizontal = 5.dp)
            .size(width = 45.dp, height = 25.dp),
          backgroundColor = colorBackAnimal,
          shape = RoundedCornerShape(10.dp)
        ) {
          Switch(
            checked = checkedAnimal, onCheckedChange = {
              vm.setSoundList("animal")
              checkedAnimal = it
              checkedSms = !checkedAnimal
              colorBackAnimal = getBackColor(checkedAnimal)
              colorBackSms = getBackColor(checkedSms)
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
      Row(
        modifier = Modifier
          .weight(1f)
          .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = "  SMS ",
          color = Color.White,
          fontSize = 30.sp,
          fontFamily = stardewValleyFont,
          fontWeight = FontWeight.Normal,
          modifier = Modifier
            .padding(horizontal = 5.dp)
            .weight(1f)
        )

        Card(
          modifier = Modifier
            .padding(horizontal = 5.dp)
            .size(width = 45.dp, height = 25.dp),
          backgroundColor = colorBackSms,
          shape = RoundedCornerShape(10.dp)
        ) {
          Switch(
            checked = checkedSms, onCheckedChange = {
              vm.setSoundList("sms")
              checkedSms = it
              checkedAnimal = !checkedSms
              colorBackSms = getBackColor(checkedSms)
              colorBackAnimal = getBackColor(checkedAnimal)
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
}
