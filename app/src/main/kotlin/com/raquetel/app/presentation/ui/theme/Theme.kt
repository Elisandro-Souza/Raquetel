package com.raquetel.app.presentation.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = PrimaryGreen,
    onPrimary = TextOnPrimary,
    primaryContainer = PrimaryGreenLight,
    onPrimaryContainer = TextPrimary,
    
    secondary = SecondaryOrange,
    onSecondary = TextOnPrimary,
    secondaryContainer = SecondaryOrangeLight,
    onSecondaryContainer = TextPrimary,
    
    tertiary = TertiaryBlue,
    onTertiary = TextOnPrimary,
    tertiaryContainer = TertiaryBlueLight,
    onTertiaryContainer = TextPrimary,
    
    background = BackgroundLight,
    onBackground = TextPrimary,
    
    surface = SurfaceLight,
    onSurface = TextPrimary,
    surfaceVariant = BackgroundLight,
    onSurfaceVariant = TextSecondary,
    
    error = Error,
    onError = TextOnPrimary
)

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryGreenLight,
    onPrimary = TextPrimary,
    primaryContainer = PrimaryGreenDark,
    onPrimaryContainer = TextOnPrimary,
    
    secondary = SecondaryOrangeLight,
    onSecondary = TextPrimary,
    secondaryContainer = SecondaryOrangeDark,
    onSecondaryContainer = TextOnPrimary,
    
    tertiary = TertiaryBlueLight,
    onTertiary = TextPrimary,
    tertiaryContainer = TertiaryBlueDark,
    onTertiaryContainer = TextOnPrimary,
    
    background = BackgroundDark,
    onBackground = TextOnPrimary,
    
    surface = SurfaceDark,
    onSurface = TextOnPrimary,
    surfaceVariant = BackgroundDark,
    onSurfaceVariant = TextSecondary,
    
    error = Error,
    onError = TextOnPrimary
)

@Composable
fun RaquetelTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
