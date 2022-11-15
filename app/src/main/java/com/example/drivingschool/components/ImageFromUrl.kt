package com.example.drivingschool.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ImageFromUrl(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    imageHeight: Int,
    imageWidth: Int,
    @DrawableRes placeHolder: Int,
    @DrawableRes error: Int,
    contentScale: ContentScale = ContentScale.Inside,
) {
    GlideImage(
        imageModel = imageUrl,
        modifier = modifier
            .clip(CircleShape)
            .height(dimensionResource(id = imageHeight).value.dp)
            .width(dimensionResource(id = imageWidth).value.dp),
        placeHolder = painterResource(id = placeHolder),
        error = painterResource(id = error),
        alignment = Alignment.Center,
        contentScale = contentScale,
    )
}

@Composable
fun ImageFromUrl(
    modifier: Modifier = Modifier,
    imageUrl: String?
) {
    GlideImage(
        imageModel = imageUrl,
        modifier = modifier
            .wrapContentHeight()
            .wrapContentWidth(),
    )
}