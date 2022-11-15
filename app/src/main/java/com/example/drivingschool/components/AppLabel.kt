package com.example.drivingschool.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.drivingschool.ui.theme.AppTheme


@Composable
fun AppLabel(
    modifier: Modifier = Modifier,
    leadingText: String,
    trailingText: String = "",
    trailingTextOnclick: () -> Unit = {},
    trailingClickable: Boolean = true,
    trailingTextColor: Color = AppTheme.colors.success,
    leadingStyle: TextStyle = AppTheme.typography.subtitle1.copy(
        fontWeight = FontWeight.Bold,
        color = AppTheme.colors.textPrimary
    ),
    trailingStyle: TextStyle = AppTheme.typography.subtitle1.copy(
        fontWeight = FontWeight.Bold,
        color = trailingTextColor
    )
) {
    Row(
        modifier = modifier.padding(vertical = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppText(
            textLeft = leadingText,
            style = leadingStyle,
        )

        AppText(
            modifier = Modifier
                .clickable(enabled = trailingClickable,
                    onClick = {
                        trailingTextOnclick()
                    }),
            textRight = trailingText,
            style = trailingStyle
        )

    }

}