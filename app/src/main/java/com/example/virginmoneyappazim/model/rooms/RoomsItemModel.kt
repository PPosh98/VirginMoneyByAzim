package com.example.virginmoneyappazim.model.rooms


import com.google.gson.annotations.SerializedName

data class RoomsItemModel(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("isOccupied")
    val isOccupied: Boolean,
    @SerializedName("maxOccupancy")
    val maxOccupancy: Int
)