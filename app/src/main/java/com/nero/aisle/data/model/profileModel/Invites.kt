package com.nero.aisle.data.model.profileModel


import com.google.gson.annotations.SerializedName

data class Invites(
    @SerializedName("pending_invitations_count")
    val pendingInvitationsCount: Int?,
    @SerializedName("profiles")
    val profiles: List<Profile>?,
    @SerializedName("totalPages")
    val totalPages: Int?
)