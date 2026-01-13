package com.gtsoft.wintertravelgallery.core.model

import androidx.annotation.DrawableRes

data class GalleryItem(
    val name: String,
    val title: String,
    @DrawableRes val imageRes: Int
)