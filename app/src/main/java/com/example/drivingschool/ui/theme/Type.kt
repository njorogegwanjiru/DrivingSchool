package com.example.drivingschool.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.drivingschool.R

val QuickSand = FontFamily(
    Font(R.font.quicksand_light, weight = FontWeight.Light),
    Font(R.font.quicksand_regular, weight = FontWeight.Normal),
    Font(R.font.quicksand_medium, weight = FontWeight.Medium),
    Font(R.font.quicksand_semibold, weight = FontWeight.SemiBold),
    Font(R.font.quicksand_bold, weight = FontWeight.Bold)
)

class AppTypography internal constructor(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val h5: TextStyle,
    val h6: TextStyle,
    val subtitle1: TextStyle,
    val subtitle2: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle
) {
    constructor(
        defaultFontFamily: FontFamily = QuickSand,
        h1: TextStyle = TextStyle(
            fontFamily = QuickSand,
            fontWeight = FontWeight.SemiBold,
            fontSize = (32).sp,
        ),
        h2: TextStyle = TextStyle(
            fontFamily = QuickSand,
            fontWeight = FontWeight.SemiBold,
            fontSize = (28).sp,
        ),
        h3: TextStyle = TextStyle(
            fontFamily = QuickSand,
            fontWeight = FontWeight.SemiBold,
            fontSize = (24).sp
        ),
        h4: TextStyle = TextStyle(
            fontFamily = QuickSand,
            fontWeight = FontWeight.SemiBold,
            fontSize = (24).sp,
        ),
        h5: TextStyle = TextStyle(
            fontFamily = QuickSand,
            fontWeight = FontWeight.SemiBold,
            fontSize = (20).sp,
        ),
        h6: TextStyle = TextStyle(
            fontFamily = QuickSand,
            fontWeight = FontWeight.Medium,
            fontSize = (18).sp,
        ),
        subtitle1: TextStyle = TextStyle(
            fontFamily = QuickSand,
            fontWeight = FontWeight.Medium,
            fontSize = (16).sp
        ),
        subtitle2: TextStyle = TextStyle(
            fontFamily = QuickSand,
            fontWeight = FontWeight.Medium,
            fontSize = (14).sp
        ),
        body1: TextStyle = TextStyle(
            fontFamily = QuickSand,
            fontWeight = FontWeight.Medium,
            fontSize = (13).sp,
        ),

        body2: TextStyle = TextStyle(
            fontFamily = QuickSand,
            fontWeight = FontWeight.Medium,
            fontSize = (12).sp,
        ),
    ) : this(
        h1 = h1.withDefaultFontFamily(defaultFontFamily),
        h2 = h2.withDefaultFontFamily(defaultFontFamily),
        h3 = h3.withDefaultFontFamily(defaultFontFamily),
        h4 = h4.withDefaultFontFamily(defaultFontFamily),
        h5 = h5.withDefaultFontFamily(defaultFontFamily),
        h6 = h6.withDefaultFontFamily(defaultFontFamily),
        subtitle1 = subtitle1.withDefaultFontFamily(defaultFontFamily),
        subtitle2 = subtitle2.withDefaultFontFamily(defaultFontFamily),
        body1 = body1.withDefaultFontFamily(defaultFontFamily),
        body2 = body2.withDefaultFontFamily(defaultFontFamily),
    )
}

private fun TextStyle.withDefaultFontFamily(default: FontFamily): TextStyle {
    return if (fontFamily != null) this else copy(fontFamily = default)
}