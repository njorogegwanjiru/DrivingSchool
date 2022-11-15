package com.example.drivingschool.components

import androidx.annotation.ColorRes
import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.drivingschool.R
import com.example.drivingschool.ui.theme.AppTheme

@Composable
fun AppCloseBtn(
    modifier: Modifier = Modifier,
    iconDrawable: Int = R.drawable.ic_back,
    @ColorRes tint: Color = AppTheme.colors.brand,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier.clickable(enabled = true, onClick = onClick),
        onClick = { onClick() },
        content = {
            Icon(
                painter = painterResource(id = iconDrawable),
                contentDescription = "closeBackButton",
                tint = tint
            )
        }
    )
}