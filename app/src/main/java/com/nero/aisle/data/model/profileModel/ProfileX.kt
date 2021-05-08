package com.nero.aisle.data.model.profileModel


import com.google.gson.annotations.SerializedName

data class ProfileX(
    @SerializedName("avatar")
    val avatar: String?,
    @SerializedName("first_name")
    val firstName: String?
)