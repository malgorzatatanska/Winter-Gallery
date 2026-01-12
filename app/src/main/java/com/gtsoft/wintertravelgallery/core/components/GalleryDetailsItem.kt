package com.gtsoft.wintertravelgallery.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.gtsoft.wintertravelgallery.ui.theme.BgGallery


@Composable
fun GalleryDetailsItem(
    url: String, modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))

    ) {
        SubcomposeAsyncImage(
            model = url,
            loading = {
                LoadingStateGalleryItem()
            },
            error = {
                ErrorStateGalleryItem()
            },
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .background(BgGallery),

            )
    }

}