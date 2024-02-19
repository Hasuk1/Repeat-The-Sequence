# **Android Simon Says Game Compose**

It's a game similar to Simon Says. 
You need to repeat a sequence of sounds. With each successful level, the length of the sequence increases. If you make a mistake, the game ends.

## **Screenshots**
![SimonSaysGameScreenshot](misc/SimonSaysGameScreenshot.png)

## **Features**

The interface and logic of the game has been implemented. 
There is also the possibility of free play, where there is no set sequence.
In the settings you can enable/disable animation of clicks during the game, enable/disable sound, set a delay between sounds when playing a sequence of sounds, and set a different sound theme.

## **Stack**

<div>
    <img src="https://github.com/devicons/devicon/blob/master/icons/kotlin/kotlin-original.svg"width="40" height="40"/>&nbsp;
    <img src="https://github.com/devicons/devicon/blob/master/icons/jetpackcompose/jetpackcompose-original.svg"width="40" height="40"/>&nbsp;
    <img src="https://github.com/devicons/devicon/blob/master/icons/gradle/gradle-original.svg"width="40" height="40"/>&nbsp;
    <img src="https://github.com/devicons/devicon/blob/master/icons/androidstudio/androidstudio-original.svg"width="40" height="40"/>&nbsp;
    <img src="https://github.com/devicons/devicon/blob/master/icons/android/android-original.svg"width="40" height="40"/>
</div>

## **File structure**

```kotlin
app
├── src
│   ├── main
│   │   ├── java/com/example/repeat_the_sequence
│   │   │   ├── enums
│   │   │   │   ├── AppScreens.kt
│   │   │   │   └── GameState.kt
│   │   │   ├── nav
│   │   │   │   ├── NavHost.kt
│   │   │   │   └── Screens.kt
│   │   │   ├── ui
│   │   │   │   ├── components
│   │   │   │   │   ├── buttons
│   │   │   │   │   │   ├── BackArrowButton.kt
│   │   │   │   │   │   ├── RectangleButton.kt
│   │   │   │   │   │   └── SquareButton.kt
│   │   │   │   │   ├── combobox
│   │   │   │   │   │   └── SoundListComboBox.kt
│   │   │   │   │   ├── images
│   │   │   │   │   │   ├── BackgroundImage.kt
│   │   │   │   │   │   └── GameLogo.kt
│   │   │   │   │   ├── information
│   │   │   │   │   │   ├── GameInfo.kt
│   │   │   │   │   │   ├── GameInvitation.kt
│   │   │   │   │   │   └── LoseInfo.kt
│   │   │   │   │   ├── sliders
│   │   │   │   │   │   └── SoundDelaySlider.kt
│   │   │   │   │   └── switches
│   │   │   │   │       ├── SoundEnabledSwitcher.kt
│   │   │   │   │       └── ButtonBacklightSwitcher.kt
│   │   │   │   ├── screens
│   │   │   │   │   ├── AboutAppScreen.kt
│   │   │   │   │   ├── GameSettingsScreen.kt
│   │   │   │   │   ├── GameScreen.kt
│   │   │   │   │   ├── MenuScreen.kt
│   │   │   │   │   └── LoseScreen.kt
│   │   │   │   ├── types
│   │   │   │   │   └── Type.kt
│   │   │   │   └── theme
│   │   │   │       ├── Color.kt
│   │   │   │       ├── Shape.kt
│   │   │   │       └── Theme.kt
│   │   │   ├── viewmodel
│   │   │   │   └── SimonGameViewModel.kt
│   │   │   └── MainActivity.kt
│   │   └── ...
│   └── ...
└── ...
```