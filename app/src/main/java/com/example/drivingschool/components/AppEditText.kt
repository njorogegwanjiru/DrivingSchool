package com.example.drivingschool.components

import androidx.annotation.DimenRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.drivingschool.ui.theme.AppTheme


@Composable
fun AppEditText(
    modifier: Modifier = Modifier,
    radius: Dp = 13.dp,
    value: String = "",
    label: String = "",
    hasError: Boolean = false,
    fieldPlaceholder: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    textStyle: TextStyle = AppTheme.typography.subtitle1.copy(
        fontWeight = FontWeight.Bold,
        color = if (hasError) AppTheme.colors.error else AppTheme.colors.textPrimary
    ),
    placeHolderStyle: TextStyle = AppTheme.typography.subtitle2.copy(
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        color = AppTheme.colors.grey
    ),
    onValueChanged: (String) -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.Words,
        imeAction = ImeAction.Done,
    ),
    enabled: Boolean = true,
    maxChar: Int = 0,

    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    var textState by remember { mutableStateOf(value) }
    textState = value

    val isInactiveState = remember { mutableStateOf(true) }
    val focusManager = LocalFocusManager.current

    Card(
        modifier = modifier
            .height(56.dp)
            .onFocusChanged { isInactiveState.value = !it.isFocused },
        shape = RoundedCornerShape(radius),
        border = BorderStroke(
            width = 2.dp,
            color = if (isInactiveState.value) AppTheme.colors.grey.copy(alpha = .3f) else AppTheme.colors.transparent
        ),
        elevation = if (isInactiveState.value) 0.dp else 2.dp,
        backgroundColor = AppTheme.colors.white
    ) {
        TextField(
            textStyle = textStyle,
            enabled = enabled,
            modifier = Modifier
                .fillMaxSize()
                .onFocusChanged { isInactiveState.value = !it.isFocused },
            value = textState,
            onValueChange = {
                if (maxChar != 0) {
                    if (it.length <= maxChar) {
                        textState = it
                        onValueChanged(it)
                    }
                } else {
                    textState = it
                    onValueChanged(it)
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = AppTheme.colors.transparent,
                cursorColor = Color.Black,
                disabledLabelColor = AppTheme.colors.white,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            placeholder = {
                AppText(
                    modifier = Modifier.padding(),
                    text = fieldPlaceholder.ifEmpty { label },
                    style = placeHolderStyle,
                    alignment = TextAlign.Left
                )
            },
            singleLine = true,
            keyboardOptions = keyboardOptions,
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            shape = RoundedCornerShape(radius),
            visualTransformation = visualTransformation
        )
    }

}