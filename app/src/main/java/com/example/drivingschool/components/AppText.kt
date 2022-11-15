package com.example.drivingschool.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    opacity: Float = 1.0F,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    alignment: TextAlign = TextAlign.Center,
    textDecoration: TextDecoration = TextDecoration.None,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        modifier = modifier.alpha(opacity) ,
        text = text,
        style = style,
        textAlign = alignment,
        textDecoration = textDecoration,
        letterSpacing = letterSpacing,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines
    )
}

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    textLeft:String,
    style: TextStyle,
    opacity: Float = 1.0F,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        modifier = modifier.alpha(opacity) ,
        text = textLeft,
        style = style,
        textAlign = TextAlign.Left,
        textDecoration = textDecoration,
        letterSpacing = letterSpacing,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines
    )
}

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    textRight:String,
    style: TextStyle,
    opacity: Float = 1.0F,
    textDecoration: TextDecoration = TextDecoration.None,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        modifier = modifier.alpha(opacity) ,
        text = textRight,
        style = style,
        textAlign = TextAlign.Right,
        textDecoration = textDecoration,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines
    )
}

