package com.example.virginmoneyappazim.repository

import com.example.virginmoneyappazim.api.FetchAPI
import com.example.virginmoneyappazim.model.people.PeopleItemModel
import com.example.virginmoneyappazim.model.rooms.RoomsItemModel
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val fetchAPI: FetchAPI): Repository {
    override fun getPeople(): Response<ArrayList<PeopleItemModel>> = fetchAPI.getPeople()

    override fun getRooms(): Response<ArrayList<RoomsItemModel>> = fetchAPI.getRooms()
}