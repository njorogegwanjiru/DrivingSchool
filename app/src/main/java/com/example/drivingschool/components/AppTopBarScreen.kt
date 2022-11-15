package com.example.drivingschool.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.drivingschool.R
import com.example.drivingschool.ui.theme.AppTheme

@Composable
fun AppTopBarScreen(
    onNavClick: () -> Unit,
    body: @Composable () -> Unit,
    action: (@Composable () -> Unit)={},
    title: String? = null,
    @DrawableRes navIcon: Int = R.drawable.ic_back,
    iconTint: Color = AppTheme.colors.brand,
) {
    Scaffold(Modifier.fillMaxSize(),
        backgroundColor = AppTheme.colors.white,
        topBar = {
            TopAppBar(
                backgroundColor = AppTheme.colors.white,
                elevation = 2.dp,
                title = {
                    if (title != null) {
                        AppText(
                            text = title,
                            style = AppTheme.typography.h5.copy(
                                fontSize = 16.sp,
                                color = AppTheme.colors.textPrimary
                            ),
                        )
                    }
                },
                navigationIcon = {
                    AppCloseBtn(
                        onClick = onNavClick,
                        iconDrawable = navIcon,
                        tint = iconTint
                    )
                }
            )
        }) {
        Column(Modifier.padding(it)) {
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxWidth()) {
                body()
            }

            Box(modifier = Modifier.imePadding().padding(horizontal = 16.dp)) {
                action()
            }

            Spacer(modifier = Modifier.height(24.dp))

        }

    }
}