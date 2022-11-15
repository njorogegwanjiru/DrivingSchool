package com.example.drivingschool.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.drivingschool.ui.theme.AppTheme

@Composable
fun AppButton(
    modifier: Modifier,
    buttonText: String,
    buttonTextStyle: TextStyle = AppTheme.typography.subtitle1.copy(
        color = AppTheme.colors.white,
        fontWeight = FontWeight.SemiBold
    ),
    enabledButtonColor: Color = AppTheme.colors.brand,
    disabledButtonColor: Color = AppTheme.colors.brandSecondary,
    elevation: Dp = 1.dp,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    Card(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
            .clickable {
                if (enabled) {
                    onClick()
                }
            },
        backgroundColor = if (enabled) enabledButtonColor else disabledButtonColor,
        elevation = elevation,
        shape = RoundedCornerShape(13.dp),
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            AppText(
                modifier = Modifier.fillMaxWidth(),
                text = buttonText,
                style = buttonTextStyle,
                alignment = TextAlign.Center,
                maxLines = 1
            )
        }
    }
}

