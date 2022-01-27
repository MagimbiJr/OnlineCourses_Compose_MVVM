package com.tana.onlinecourses.ui.components.buttons


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.tana.onlinecourses.ui.theme.EerieBlack
import com.tana.onlinecourses.ui.theme.JazzberryJam
import com.tana.onlinecourses.ui.theme.Shapes

@Composable
fun OutlineButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color = if (isSystemInDarkTheme()) EerieBlack else
        MaterialTheme.colors.surface,
    modifier: Modifier = Modifier
) {
    val brush = Brush.horizontalGradient(
        listOf(
            MaterialTheme.colors.primary,
            JazzberryJam
        )
    )
    val buttonColors = ButtonDefaults.outlinedButtonColors(
        backgroundColor = backgroundColor
    )
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        border = BorderStroke(width = 2.dp, brush = brush),
        shape = Shapes.medium,
        colors = buttonColors
    ) {
        Text(
            text = text.toUpperCase(Locale.current),
        )
    }
}