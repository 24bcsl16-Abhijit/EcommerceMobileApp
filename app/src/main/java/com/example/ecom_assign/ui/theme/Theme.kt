package com.example.ecom_assign.ui.theme

import androidx.compose.ui.graphics.Color
import android.app.Activity
import android.os.BuildAdd commentMore actions
import androidx.compose.foundation.isSystemInDarkTheme
@@ -9,58 +10,56 @@ import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.ecom_assign.R

val ClashDisplay = FontFamily(
    Font(R.font.clash_display_bold, FontWeight.Bold)
)
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    primary = PrimaryPurple,
    secondary = PurpleGrey80,
    tertiary = Pink80
            tertiary = Pink80,
    background = Color.White,
    surface = BackgroundLightGray
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    primary = PrimaryPurple,
    secondary = PurpleGrey40,
    tertiary = Pink40

            /* Other default colors to override
            background = Color(0xFFFFFBFE),
            surface = Color(0xFFFFFBFE),
            onPrimary = Color.White,
            onSecondary = Color.White,
            onTertiary = Color.White,
            onBackground = Color(0xFF1C1B1F),
            onSurface = Color(0xFF1C1B1F),
            */
            tertiary = Pink40,
    background = Color.White,
    surface = BackgroundLightGray
)

@Composable
fun EcommerceApp_assignmentTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
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
        typography = Typography,
        content = content
    )
}