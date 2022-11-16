package com.example.drivingschool.screens.authentication.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.drivingschool.components.*
import com.example.drivingschool.ui.theme.AppTheme
import com.example.drivingschool.ui.theme.Theme

@Composable
fun HomeScreen() {
    Scaffold(
        Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        backgroundColor = AppTheme.colors.white,
        topBar = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = com.example.drivingschool.R.drawable.ic_baseline_menu_24),
                        contentDescription = "menu"
                    )
                }

                ImageFromRes(modifier = Modifier.size(40.dp))
            }
        }) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp)
        ) {

            AppLabel(leadingText = "Book practical")
            BookPracticalBanner()

            Spacer(modifier = Modifier.height(16.dp))
            AppLabel(
                leadingText = "Lessons",
                trailingText = "View All",
                trailingClickable = true,
                trailingTextOnclick = {})
            LessonsCard()

            Spacer(modifier = Modifier.height(16.dp))
            AppLabel(
                leadingText = "Payments",
                trailingText = "View All",
                trailingClickable = true,
                trailingTextOnclick = {})
            PaymentsCard()
        }

    }


}

@Composable
fun LessonsCard() {
    BorderedCard {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                AppText(
                    modifier = Modifier.weight(1f),
                    textLeft = "Lesson Name",
                    style = AppTheme.typography.h6.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = AppTheme.colors.textPrimary
                    ),
                )
                AppText(
                    modifier = Modifier.weight(.5f),
                    textRight = "Date, Time",
                    style = AppTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.Medium,
                        color = AppTheme.colors.textSecondary
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            AppText(
                textLeft = "Instructor name",
                style = AppTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.Normal,
                    color = AppTheme.colors.textSecondary
                )
            )
        }
    }
}

@Composable
fun PaymentsCard() {
    BorderedCard {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageFromRes(
                    modifier = Modifier
                        .size(40.dp)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(Modifier.wrapContentHeight()) {
                    AppText(
                        textLeft = "Reference",
                        style = AppTheme.typography.h6.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = AppTheme.colors.textPrimary
                        ),
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    AppText(
                        textLeft = "M-PESA",
                        style = AppTheme.typography.subtitle1.copy(
                            fontWeight = FontWeight.Normal,
                            color = AppTheme.colors.textSecondary
                        )
                    )
                }

                AppText(
                    modifier = Modifier.weight(1f),
                    textRight = "+ KES 2000.00",
                    style = AppTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.Medium,
                        color = AppTheme.colors.success
                    )
                )
            }

        }
    }
}

@Composable
fun BookPracticalBanner() {
    BorderedCard {
        Box(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            ImageFromRes(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.TopEnd),
                imageRes = com.example.drivingschool.R.drawable.car,
                colorFilter = ColorFilter.tint(AppTheme.colors.brand, blendMode = BlendMode.Lighten)
            )

            AppText(
                modifier = Modifier.align(Alignment.TopStart),
                textLeft = "Book a practical lesson now...",
                style = AppTheme.typography.subtitle1.copy(color = AppTheme.colors.textPrimary)
            )

            AppButton(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .width(150.dp)
                    .height(40.dp),
                buttonText = "BOOK NOW",
                onClick = {})
        }

    }
}

@Preview
@Composable
fun HomePrev() {
    Theme {
        HomeScreen()
    }
}

@Preview
@Composable
fun LessonPrev() {
    Theme {
        LessonsCard()
    }
}

@Preview
@Composable
fun PaymentPrev() {
    Theme {
        PaymentsCard()
    }
}

@Preview
@Composable
fun BookPrev() {
    Theme {
        BookPracticalBanner()
    }
}