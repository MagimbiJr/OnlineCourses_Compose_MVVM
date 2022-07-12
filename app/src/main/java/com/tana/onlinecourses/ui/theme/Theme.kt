package com.tana.onlinecourses.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = SapphireBlue,
    surface = Color.Black,
    onSurface = AliceBlue,
    onPrimary = AliceBlue,
    background = RichBlackFOGRA39,
    onBackground = AliceBlue
)

private val LightColorPalette = lightColors(
    primary = SapphireBlue,
    onPrimary = AliceBlue,
    background = AliceBlue,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black
)

@Composable
fun OnlineCoursesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}