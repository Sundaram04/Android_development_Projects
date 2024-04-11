package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmations(
    @StringRes val stringResourceId: Int,       //stringResourceId represents an ID for the affirmation text stored in a string resource
    @DrawableRes val imageResourceId: Int       //imageResourceId represents an ID for the affirmation image stored in a drawable resource.
)
