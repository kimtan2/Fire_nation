package com.example.firenation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.firenation.R


val PermanentMarker = FontFamily(
    Font(R.font.perm_reg)
)

val Satis = FontFamily(
    Font(R.font.satis_reg)
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),


    titleLarge = TextStyle(
        fontFamily = PermanentMarker,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,

    ),
    labelSmall = TextStyle(
        fontFamily = Satis,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,

    )

)