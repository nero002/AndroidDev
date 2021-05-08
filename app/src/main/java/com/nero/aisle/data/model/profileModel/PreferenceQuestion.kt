package com.nero.aisle.data.model.profileModel


import com.google.gson.annotations.SerializedName

data class PreferenceQuestion(
    @SerializedName("first_choice")
    val firstChoice: String?,
    @SerializedName("second_choice")
    val secondChoice: String?
)