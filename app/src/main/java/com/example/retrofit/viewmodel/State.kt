package com.example.retrofit.viewmodel

sealed class State {
    data object Loading : State()
    data object Success : State()
    data class Error(val nameError: String = "Ошибка запроса") : State()
}
