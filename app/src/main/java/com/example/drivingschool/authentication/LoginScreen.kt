package com.example.drivingschool.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.drivingschool.components.AppButton
import com.example.drivingschool.components.AppEditText
import com.example.drivingschool.components.AppText
import com.example.drivingschool.components.ImageFromRes
import com.example.drivingschool.ui.theme.AppTheme
import com.example.drivingschool.ui.theme.Theme

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(AppTheme.colors.white)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(.2f))

        ImageFromRes(
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        AppText(
            text = "Proceed with your",
            style = AppTheme.typography.h4.copy(
                color = AppTheme.colors.textPrimary,
                fontWeight = FontWeight.Medium
            ),
            alignment = TextAlign.Left
        )

        AppText(
            text = "Login",
            style = AppTheme.typography.h2.copy(
                color = AppTheme.colors.textPrimary,
                fontWeight = FontWeight.Bold
            ),
            alignment = TextAlign.Left
        )

        Spacer(modifier = Modifier.weight(.1f))

        AppEditText(
            modifier = Modifier.fillMaxWidth(),
            fieldPlaceholder = "Email",
            onValueChanged = {}
        )

        Spacer(modifier = Modifier.height(24.dp))

        AppEditText(
            modifier = Modifier.fillMaxWidth(),
            fieldPlaceholder = "Password",
            onValueChanged = {}
        )

        Spacer(modifier = Modifier.weight(.5f))

        AppButton(
            modifier = Modifier.navigationBarsPadding(),
            buttonText = "Login",
            onClick = {})
    }
}

@Preview
@Composable
fun LoginPrev() {
    val navController = rememberNavController()
    Theme {
        LoginScreen(navController = navController)
    }
}