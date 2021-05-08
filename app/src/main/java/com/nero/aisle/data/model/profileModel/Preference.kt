package com.nero.aisle.data.model.profileModel


import com.google.gson.annotations.SerializedName

data class Preference(
    @SerializedName("answer_id")
    val answerId: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("preference_question")
    val preferenceQuestion: PreferenceQuestion?,
    @SerializedName("value")
    val value: Int?
)