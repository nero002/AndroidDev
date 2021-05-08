package com.nero.aisle.data.model.profileModel


import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("photo")
    val photo: String?,
    @SerializedName("photo_id")
    val photoId: Int?,
    @SerializedName("selected")
    val selected: Boolean?,
    @SerializedName("status")
    val status: String?
)