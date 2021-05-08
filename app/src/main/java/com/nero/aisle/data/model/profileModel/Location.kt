package com.nero.aisle.data.model.profileModel


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("full")
    val full: String?,
    @SerializedName("summary")
    val summary: String?
)