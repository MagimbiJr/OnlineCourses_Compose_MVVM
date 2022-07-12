package com.tana.onlinecourses.ui.components.buttons


import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp

@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colors.primary
) {
    TextButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text = text.toUpperCase(Locale.current),
            color = textColor,
            modifier = modifier
                .padding(horizontal = 16.dp)
        )
    }
}