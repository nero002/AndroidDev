package com.nero.aisle.data.model.profileModel


import com.google.gson.annotations.SerializedName

data class PreferenceX(
    @SerializedName("answer")
    val answer: String?,
    @SerializedName("answer_id")
    val answerId: Int?,
    @SerializedName("first_choice")
    val firstChoice: String?,
    @SerializedName("second_choice")
    val secondChoice: String?
)