package br.com.easypallet.presentation.theme

import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material.Colors

val Red = Color(0xFFBB1822)
val RedDark = Color(0xFF631317)
val White = Color(0xFFFFFFFF)
val Red400 = Color(0xFFCF6679)

internal val wearColorPalette: Colors = Colors(
    primary = Red,
    primaryVariant = RedDark,
    secondary = White,
    secondaryVariant = White,
    error = Red400,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onError = Color.Black,
    background = White
)