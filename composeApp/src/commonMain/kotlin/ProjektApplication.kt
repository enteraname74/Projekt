package com.github.enteraname74.projekt

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.github.enteraname74.projekt.feature.home.HomeScreen
import coreui.theme.AppTheme

@Composable
internal fun ProjektApplication() = AppTheme {
    Navigator(
        HomeScreen()
    )
}