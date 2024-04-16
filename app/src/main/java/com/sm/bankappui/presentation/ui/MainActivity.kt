package com.sm.bankappui.presentation.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sm.bankappui.presentation.ui.components.navbar.BottomNavBar
import com.sm.bankappui.presentation.theme.AppTheme
import com.sm.bankappui.presentation.ui.components.sections.CardSection
import com.sm.bankappui.presentation.ui.components.sections.CurrenciesSection
import com.sm.bankappui.presentation.ui.components.sections.FinanceSection
import com.sm.bankappui.presentation.ui.components.sections.WalletSection

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {

                SetStatusBarColor(color = MaterialTheme.colorScheme.background)

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}


@Composable
private fun SetStatusBarColor(color: Color) {
    val systemUIController = rememberSystemUiController()
    SideEffect {
        systemUIController.setStatusBarColor(color = color)
    }
}

@Composable
private fun HomeScreen() {
    Scaffold(bottomBar = {

        BottomNavBar()
    },
        content = { padding ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(padding)) {
                WalletSection()
                CardSection()
                Spacer(modifier = Modifier.height(16.dp))
                FinanceSection()
                CurrenciesSection()
            }
        })
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun P_1() {
    AppTheme {
        HomeScreen()
    }
}