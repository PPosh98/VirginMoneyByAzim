package com.example.virginmoneyappazim.api

import com.example.virginmoneyappazim.model.people.PeopleItemModel
import com.example.virginmoneyappazim.model.rooms.RoomsItemModel
import retrofit2.Response
import retrofit2.http.GET

interface FetchAPI {

    @GET("people")
    fun getPeople(): Response<ArrayList<PeopleItemModel>>

    @GET("rooms")
    fun getRooms(): Response<ArrayList<RoomsItemModel>>
}