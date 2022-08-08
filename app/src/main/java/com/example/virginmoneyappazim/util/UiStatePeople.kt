package com.example.virginmoneyappazim.util

import com.example.virginmoneyappazim.model.people.People

sealed class UiStatePeople {
    object Loading: UiStatePeople()
    data class Success(val peopleResponse: People): UiStatePeople()
    data class Error(val error: Throwable): UiStatePeople()
}
