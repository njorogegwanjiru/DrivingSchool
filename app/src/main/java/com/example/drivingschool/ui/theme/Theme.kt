package com.example.drivingschool.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

private val LightColorPalette = AppColors(
    brand = brand,
    brandSecondary = brandSecondary,
    textPrimary = textPrimary,
    textSecondary = textSecondary,
    white = white,
    grey = grey,
    error = error,
    success = success,
    transparent = transparent,
)

@Stable
class AppColors(
    brand: Color,
    brandSecondary: Color,
    textPrimary: Color,
    textSecondary: Color,
    white: Color,
    error: Color,
    grey: Color,
    success: Color,
    transparent: Color,
)
{
    var brand by mutableStateOf(brand)
        private set

    var brandSecondary by mutableStateOf(brandSecondary)
        private set

    var textPrimary by mutableStateOf(textPrimary)
        private set

    var textSecondary by mutableStateOf(textSecondary)
        private set

    var white by mutableStateOf(white)
        private set

    var error by mutableStateOf(error)
        private set

    var grey by mutableStateOf(grey)
        private set

    var success by mutableStateOf(success)
        private set

    var transparent by mutableStateOf(transparent)
        private set

    fun update(other: AppColors) {
       brand = other.brand
        brandSecondary = other.brandSecondary
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        white = other.white
        error = other.error
        grey = other.grey
        success = other.success
        transparent = other.transparent
    }

    fun copy(): AppColors = AppColors(
        brand = com.example.drivingschool.ui.theme.brand,
        brandSecondary = com.example.drivingschool.ui.theme.brandSecondary,
        textPrimary = com.example.drivingschool.ui.theme.textPrimary,
        textSecondary = com.example.drivingschool.ui.theme.textSecondary,
        white = com.example.drivingschool.ui.theme.white,
        error = com.example.drivingschool.ui.theme.error,
        grey = com.example.drivingschool.ui.theme.grey,
        success = com.example.drivingschool.ui.theme.success,
        transparent = com.example.drivingschool.ui.theme.transparent,
    )
}


@Composable
fun Theme(
    content: @Composable () -> Unit
) {
    val colors = LightColorPalette
    val typography = AppTypography()

    ProvideAppTheme(colors = colors, typography = typography) {
        MaterialTheme(
            colors = debugColors(false),
            shapes = Shapes,
            content = content
        )
    }
}

object AppTheme {
    val colors: AppColors
        @Composable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}

private val LocalTypography = staticCompositionLocalOf<AppTypography> {
    error("No Typography provided")
}

private val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("No AppColorPalette provided")
}

@Composable
fun ProvideAppTheme(
    colors: AppColors,
    typography: AppTypography,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        colors.copy()
    }
    colorPalette.update(colors)
    CompositionLocalProvider(
        LocalAppColors provides colorPalette,
        LocalTypography provides typography,
        content = content
    )
}

fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Magenta
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)
