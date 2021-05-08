package com.nero.aisle.data.model.profileModel


import com.google.gson.annotations.SerializedName

data class SunSignV1(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)