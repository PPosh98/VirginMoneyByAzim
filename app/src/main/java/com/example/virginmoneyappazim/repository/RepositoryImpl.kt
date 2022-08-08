package com.example.virginmoneyappazim.repository

import com.example.virginmoneyappazim.api.FetchAPI
import com.example.virginmoneyappazim.model.people.People
import com.example.virginmoneyappazim.model.people.PeopleItemModel
import com.example.virginmoneyappazim.model.rooms.Rooms
import com.example.virginmoneyappazim.model.rooms.RoomsItemModel
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val fetchAPI: FetchAPI): Repository {
    override suspend fun getPeople(): Response<People> = fetchAPI.getPeople()

    override suspend fun getRooms(): Response<Rooms> = fetchAPI.getRooms()
}