package com.github.enteraname74.projekt

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.github.enteraname74.projekt.feature.home.HomeScreen
import coreui.screen.PktScreen
import coreui.theme.AppTheme

@Composable
internal fun ProjektApplication() = AppTheme {
    PktScreen {
        Navigator(
            HomeScreen()
        ) { navigator ->
            SlideTransition(
                navigator = navigator
            )
        }
    }
}