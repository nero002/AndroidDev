package com.nero.aisle.data.model.profileModel


import com.google.gson.annotations.SerializedName

data class SmokingV1(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("name_alias")
    val nameAlias: String?
)