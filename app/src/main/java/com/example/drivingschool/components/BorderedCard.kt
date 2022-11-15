package com.example.drivingschool.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.drivingschool.ui.theme.AppTheme

@Composable
fun BorderedCard(
    backgroundColor: Color = AppTheme.colors.white,
    radius: Dp = 13.dp,
    borderWidth: Dp = 1.dp,
    borderColor: Color = AppTheme.colors.grey.copy(alpha = .3f),
    elevation: Dp = 2.dp,
    body: @Composable (() -> Unit) = {},
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        backgroundColor = backgroundColor,
        shape = RoundedCornerShape(radius),
        elevation = elevation,
        border = BorderStroke(borderWidth, borderColor)
    ) {
        body()
    }
}