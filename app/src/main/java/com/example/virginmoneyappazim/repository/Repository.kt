package com.example.virginmoneyappazim.repository

import com.example.virginmoneyappazim.model.people.People
import com.example.virginmoneyappazim.model.people.PeopleItemModel
import com.example.virginmoneyappazim.model.rooms.Rooms
import com.example.virginmoneyappazim.model.rooms.RoomsItemModel
import retrofit2.Response

interface Repository {
    suspend fun getPeople(): Response<People>

    suspend fun getRooms(): Response<Rooms>
}