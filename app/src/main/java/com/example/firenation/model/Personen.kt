package com.example.firenation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Personen(
    @DrawableRes val imageResourceId: Int,
    @StringRes val stringResourceId: Int,
    @StringRes val beschreibungPerson: Int
)
