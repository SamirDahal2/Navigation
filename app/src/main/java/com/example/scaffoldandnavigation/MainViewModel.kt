
package com.example.scaffoldandnavigation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _title = MutableStateFlow("Home Screen")
    val title: StateFlow<String> = _title

    fun title(title: String) {
        _title.value = title
    }
}
