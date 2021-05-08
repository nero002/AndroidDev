package com.nero.aisle.data.model.profileModel


import com.google.gson.annotations.SerializedName

data class ProfileData(
    @SerializedName("invitation_type")
    val invitationType: String?,
    @SerializedName("preferences")
    val preferences: List<PreferenceX>?,
    @SerializedName("question")
    val question: String?
)