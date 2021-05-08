package com.nero.aisle.data.model


import com.google.gson.annotations.SerializedName

data class TokenResponseModel(
    @SerializedName("token")
    val token: String?
)