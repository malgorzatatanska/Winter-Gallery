package com.gtsoft.wintertravelgallery.core

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.gtsoft.wintertravelgallery.core.model.GalleryListScreenViewModel
import com.gtsoft.wintertravelgallery.core.model.NavCommand
import com.gtsoft.wintertravelgallery.core.screens.GalleryDetailsListScreen
import com.gtsoft.wintertravelgallery.core.screens.GalleryListScreen
import kotlinx.coroutines.flow.collectLatest
import kotlinx.serialization.Serializable

sealed interface AppRoute : NavKey

@Serializable
data object GalleryList : AppRoute

@Serializable
data class GalleryDetailsList(val name: String) : AppRoute

@Composable
fun NavigationRoot() {

    val backStack = rememberNavBackStack(GalleryList)
    val vm: GalleryListScreenViewModel =
        viewModel<GalleryListScreenViewModel>()


    LaunchedEffect(vm) {
        vm.nav.collectLatest { event ->
            when (event) {
                is NavCommand.ToGalleryDetails -> backStack.add(
                    GalleryDetailsList(event.name)
                )

                NavCommand.Back -> backStack.removeLastOrNull()
            }
        }

    }

    NavDisplay(
        entryDecorators = listOf(
            // Add the default decorators for managing scenes and saving state
            rememberSaveableStateHolderNavEntryDecorator(),
            // Then add the view model store decorator
            rememberViewModelStoreNavEntryDecorator()
        ),
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is GalleryList -> NavEntry(key) {
                    GalleryListScreen(viewModel = vm)
                }

                is GalleryDetailsList -> NavEntry(key) {
                    GalleryDetailsListScreen(viewModel = vm, key.name)
                }

                else -> NavEntry(key) { Text("Unknown route") }
            }
        }

    )

}