package com.gtsoft.wintertravelgallery.core.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import com.gtsoft.wintertravelgallery.core.components.GalleryScreenContent
import com.gtsoft.wintertravelgallery.core.model.GalleryListScreenViewModel
import com.gtsoft.wintertravelgallery.ui.theme.BgMain
import com.gtsoft.wintertravelgallery.ui.theme.TextPrimary


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleryListScreen(
    viewModel: GalleryListScreenViewModel, modifier:
    Modifier = Modifier
) {
    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                title = {
                    Text(
                        "Winter Travel Gallery", maxLines = 1, overflow =
                            TextOverflow.Ellipsis
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BgMain,
                    titleContentColor = TextPrimary
                )
            )
        }

    ) { innerPadding ->
        GalleryScreenContent(viewModel, innerPadding)
    }


}