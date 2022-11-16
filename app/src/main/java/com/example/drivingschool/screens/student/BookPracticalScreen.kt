package com.example.drivingschool.screens.authentication.student

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.drivingschool.R
import com.example.drivingschool.components.AppButton
import com.example.drivingschool.components.AppEditText
import com.example.drivingschool.components.AppTopBarScreen
import com.example.drivingschool.ui.theme.AppTheme
import com.example.drivingschool.ui.theme.Theme

@Composable
fun BookPracticalScreen(navController: NavController) {
    var instructor by remember { mutableStateOf("") }
    var vehicle by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    AppTopBarScreen(
        onNavClick = { navController.popBackStack() },
        title = "Book Practical",
        body = {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                AppEditText(
                    fieldPlaceholder = "Instructor",
                    value = instructor,
                    onValueChanged = {
                        instructor = it
                    }
                )

                AppEditText(
                    fieldPlaceholder = "Training Vehicle",
                    value = vehicle,
                    onValueChanged = {
                        vehicle = it
                    }
                )

                AppEditText(
                    fieldPlaceholder = "Date",
                    value = date,
                    onValueChanged = {
                        date = it
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_edit_calendar_24),
                            contentDescription = "",
                            tint = AppTheme.colors.grey.copy(alpha = .5f)
                        )
                    }
                )
            }
        },
        action = {
            AppButton(modifier = Modifier.fillMaxWidth(), buttonText = "Submit", onClick = { })
        }
    )
}

@Preview
@Composable
fun Prev() {
    Theme {
        val navController = rememberNavController()
        BookPracticalScreen(navController = navController)
    }

}