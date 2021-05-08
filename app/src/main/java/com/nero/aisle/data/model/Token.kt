package com.nero.aisle.data.model


import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("number")
    val number: String?,
    @SerializedName("otp")
    val otp: String?
)