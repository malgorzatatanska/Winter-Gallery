package com.gtsoft.wintertravelgallery.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gtsoft.wintertravelgallery.R
import com.gtsoft.wintertravelgallery.core.model.GalleryItem
import com.gtsoft.wintertravelgallery.ui.theme.BgGallery

@Composable
fun GalleryScreenItem(
    item: GalleryItem, onItemClick: (name: String) -> Unit, modifier:
    Modifier =
        Modifier
) {

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                onItemClick(item.name)
            }

    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                item.name,
                color = BgGallery
            )
            Box(
                modifier = modifier
                    .background(Color.White)
                    .clip
                        (RoundedCornerShape(50.dp))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.chevron_right),
                    contentDescription = null
                )
            }

        }
    }

}