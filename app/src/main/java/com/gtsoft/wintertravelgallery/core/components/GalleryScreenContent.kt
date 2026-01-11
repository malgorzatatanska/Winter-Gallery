package com.gtsoft.wintertravelgallery.core.components

import  com.gtsoft.wintertravelgallery.R

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gtsoft.wintertravelgallery.core.model.GalleryItem
import com.gtsoft.wintertravelgallery.core.model.GalleryListScreenViewModel


val GallerListItems = listOf<GalleryItem>(
    GalleryItem(
        "ALPS",
        imageRes = R.drawable.alps
    ),
    GalleryItem(
        "LAPLAND",
        imageRes = R.drawable.lapland
    ),

    GalleryItem(
        "NORWAY",
        imageRes = R.drawable.norway_fjords
    ),
    GalleryItem(
        "ICELAND",
        imageRes = R.drawable.iceland
    ),
    GalleryItem(
        "SWISS",
        imageRes = R.drawable.swiss_villages
    ),

    GalleryItem(
        "CANADA",
        imageRes = R.drawable.canadian_rockies
    )

)

@Composable
fun GalleryScreenContent(
    viewModel: GalleryListScreenViewModel,
    innerPadding: PaddingValues
) {
    LazyVerticalGrid(
        contentPadding = innerPadding,
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier.padding(10.dp)
    ) {
        items(GallerListItems) { item ->
            GalleryScreenItem(
                item,
                onItemClick = {
                    viewModel.onClickGalleryItem(item.name)
                },
            )
        }
    }
}