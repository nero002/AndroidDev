package com.nero.aisle.data.model


import com.google.gson.annotations.SerializedName

data class StatusResponseModel(
    @SerializedName("status")
    val status: Boolean?
)