package com.example.repeat_the_sequence.enums

import com.example.repeat_the_sequence.R

enum class Sounds(val soundName: String, val emoji: String, val soundId: Int) {
  CAT_SOUND("cat_meow", "\uD83D\uDC31", R.raw.cat),
  COW_SOUND("cow_moo", "\uD83D\uDC2E", R.raw.cow),
  FROG_SOUND("frog_croak", "\uD83D\uDC38", R.raw.frog),
  PIG_SOUND("pig_grunt", "\uD83D\uDC37", R.raw.pig)
}