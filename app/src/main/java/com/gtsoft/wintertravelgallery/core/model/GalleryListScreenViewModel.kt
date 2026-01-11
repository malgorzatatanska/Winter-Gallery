package com.gtsoft.wintertravelgallery.core.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


sealed interface NavCommand {
    data class ToGalleryDetails(val name: String) : NavCommand
    data object Back : NavCommand
}

class GalleryListScreenViewModel : ViewModel() {

    private val _nav = MutableSharedFlow<NavCommand>()
    val nav = _nav.asSharedFlow()

    fun onClickGalleryItem(name: String) {
        viewModelScope.launch {
            _nav.emit(NavCommand.ToGalleryDetails(name))
        }
    }

    fun goBack() {
        viewModelScope.launch {
            _nav.emit(NavCommand.Back)
        }
    }


}