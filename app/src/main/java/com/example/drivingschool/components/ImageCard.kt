package com.example.drivingschool.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ImageCard(
    modifier: Modifier,
    height: Dp,
    width: Dp,
    radius: Dp = 0.dp,
    body: @Composable (() -> Unit)? = null,
) {
    Card(
        modifier = modifier
            .height(height)
            .width(width),
        shape = RoundedCornerShape(radius),
    ) {
        if (body != null) {
            body()
        }
    }
}