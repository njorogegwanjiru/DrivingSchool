package com.example.drivingschool.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.drivingschool.R

@Composable
fun ImageFromRes(
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Inside,
    @DrawableRes imageRes: Int = R.drawable.bg_placeholder,
    colorFilter: ColorFilter? = null
) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = "icon",
        modifier = modifier,
        contentScale = contentScale,
        alignment = Alignment.Center,
        colorFilter = colorFilter

    )
}