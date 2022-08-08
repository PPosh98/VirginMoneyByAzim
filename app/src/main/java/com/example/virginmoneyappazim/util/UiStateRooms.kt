package com.example.virginmoneyappazim.util

import com.example.virginmoneyappazim.model.rooms.Rooms

sealed class UiStateRooms {
    object Loading: UiStateRooms()
    data class Success(val roomsResponse: Rooms): UiStateRooms()
    data class Error(val error: Throwable): UiStateRooms()
}
