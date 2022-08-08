package com.example.virginmoneyappazim.api

import com.example.virginmoneyappazim.model.people.People
import com.example.virginmoneyappazim.model.people.PeopleItemModel
import com.example.virginmoneyappazim.model.rooms.Rooms
import com.example.virginmoneyappazim.model.rooms.RoomsItemModel
import retrofit2.Response
import retrofit2.http.GET

interface FetchAPI {

    @GET("people")
    suspend fun getPeople(): Response<People>

    @GET("rooms")
    suspend fun getRooms(): Response<Rooms>
}