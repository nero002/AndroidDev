package com.nero.aisle.data.model.profileModel


import com.google.gson.annotations.SerializedName

data class Likes(
    @SerializedName("can_see_profile")
    val canSeeProfile: Boolean?,
    @SerializedName("likes_received_count")
    val likesReceivedCount: Int?,
    @SerializedName("profiles")
    val profiles: List<ProfileX>?
)