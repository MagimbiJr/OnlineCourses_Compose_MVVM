package com.tana.onlinecourses.ui.components.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primary
) {
    val buttonColors = ButtonDefaults.buttonColors(
        backgroundColor = backgroundColor
    )
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = buttonColors
    ) {
        Text(
            text = text.toUpperCase(Locale.current),
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 4.dp),
            textAlign = TextAlign.Center
        )
    }
}