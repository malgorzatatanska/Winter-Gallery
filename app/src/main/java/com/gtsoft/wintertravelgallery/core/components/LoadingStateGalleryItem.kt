package com.gtsoft.wintertravelgallery.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gtsoft.wintertravelgallery.ui.theme.BgGallery
import com.gtsoft.wintertravelgallery.ui.theme.BgMainGradient
import com.gtsoft.wintertravelgallery.ui.theme.Primary

@Composable
fun LoadingStateGalleryItem(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BgMainGradient),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = Primary,
            trackColor = BgGallery
        )
    }

}