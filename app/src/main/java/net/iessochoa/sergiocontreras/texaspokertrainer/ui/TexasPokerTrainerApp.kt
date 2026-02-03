package net.iessochoa.sergiocontreras.texaspokertrainer.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.iessochoa.joseantoniolopez.t14_firebase.ui.navigation.AppNavigation
import net.iessochoa.sergiocontreras.texaspokertrainer.ui.theme.TexasPokerTrainerTheme

@Composable
fun TexasPokerTrainerApp(modifier: Modifier = Modifier) {
    TexasPokerTrainerTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//            LoginScreen (
//                modifier = Modifier.padding(innerPadding),
//                onBack = {},
//                onLoginSuccess = {},
//                onResetPassword = {}
//            )
            AppNavigation(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}