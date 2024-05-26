package com.example.retrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.api.RetrofitInstance
import com.example.retrofit.data.PersonsList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _state = MutableStateFlow<State>(State.Loading)
    val state = _state.asStateFlow()

    private val _user = MutableStateFlow<PersonsList?>(null)
    val user = _user.asStateFlow()

    private val _error = MutableStateFlow<String>("")
    val error = _error.asStateFlow()

    init {
        getUser()
    }

    fun getUser() {
        _state.value = State.Loading
        viewModelScope.launch {
            val response = RetrofitInstance.searchPersonApi.getPersonsInfo()
            if (response.isSuccessful) {
                _user.value = response.body()
                _state.value = State.Success
            } else {
                _state.value = State.Error("Ошибка загрузки данных")
            }
        }
    }
}