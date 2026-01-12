package com.gtsoft.wintertravelgallery.core.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.gtsoft.wintertravelgallery.R
import com.gtsoft.wintertravelgallery.ui.theme.BgErrorGradient

@Composable
fun ErrorStateGalleryItem(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BgErrorGradient),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.alert_triangle),
            contentDescription = null,
        )
    }

}