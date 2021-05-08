package com.nero.aisle.data.model.profileModel


import com.google.gson.annotations.SerializedName

data class ProfileResponseModel(
    @SerializedName("invites")
    val invites: Invites?,
    @SerializedName("likes")
    val likes: Likes?
)