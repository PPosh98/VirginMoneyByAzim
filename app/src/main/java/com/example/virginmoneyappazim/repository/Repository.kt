package com.example.virginmoneyappazim.repository

import com.example.virginmoneyappazim.model.people.PeopleItemModel
import com.example.virginmoneyappazim.model.rooms.RoomsItemModel
import retrofit2.Response

interface Repository {
    fun getPeople(): Response<ArrayList<PeopleItemModel>>

    fun getRooms(): Response<ArrayList<RoomsItemModel>>
}