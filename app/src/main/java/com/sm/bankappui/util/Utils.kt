package com.sm.bankappui.util

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object Utils {

    fun getGradient(start: Color, endColor: Color): Brush = Brush.horizontalGradient(
        colors = listOf(start, endColor)
    )
}