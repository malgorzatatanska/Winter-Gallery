package com.gtsoft.wintertravelgallery.core.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.gtsoft.wintertravelgallery.R
import com.gtsoft.wintertravelgallery.core.components.GalleryDetailsItem
import com.gtsoft.wintertravelgallery.core.components.GalleryScreenContent
import com.gtsoft.wintertravelgallery.core.model.GalleryListScreenViewModel
import com.gtsoft.wintertravelgallery.core.util.Destination
import com.gtsoft.wintertravelgallery.ui.theme.BgGallery
import com.gtsoft.wintertravelgallery.ui.theme.BgMain
import com.gtsoft.wintertravelgallery.ui.theme.OutlineBtn
import com.gtsoft.wintertravelgallery.ui.theme.TextPrimary


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleryDetailsListScreen(
    viewModel: GalleryListScreenViewModel,
    name: String,
    modifier: Modifier = Modifier
) {

    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = modifier.nestedScroll(
            scrollBehavior.nestedScrollConnection
        ), topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        Destination.valueOf(name).title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.W500
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BgGallery, titleContentColor = TextPrimary
                ),
                navigationIcon = {
                    IconButton(onClick = { viewModel.goBack() }) {
                        Box(
                            modifier = modifier
                                .background(Color.White)
                                .clip(RoundedCornerShape(8.dp))
                                .border(
                                    width = 1.dp,
                                    color = OutlineBtn,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(5.dp)

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.arrow_left),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }

                    }
                },
            )
        }

    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BgGallery)
                .padding(innerPadding)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier
                    .padding(10.dp)
                    .background(BgGallery)
                    .fillMaxSize()
            ) {
                items(Destination.valueOf(name).imageUrls) { url ->
                    GalleryDetailsItem(url)
                }

            }
        }

    }

}