package com.tana.onlinecourses.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tana.onlinecourses.R

private val UbuntuMedium = FontFamily(Font(R.font.ubuntu_medium))
private val UbuntuRegular = FontFamily(Font(R.font.ubuntu_regular))
private val UbuntuLight = FontFamily(Font(R.font.ubuntu_light))

// Set of Material typography styles to start with
val Typography = Typography(
    subtitle1 = TextStyle(
        fontFamily = UbuntuRegular,
        fontWeight = FontWeight.W500,
        fontSize = 26.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = UbuntuRegular,
        fontWeight = FontWeight.W500,
        fontSize = 22.sp
    ),
    body1 = TextStyle(
        fontFamily = UbuntuLight,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = UbuntuLight,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = UbuntuMedium,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = UbuntuMedium,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

)