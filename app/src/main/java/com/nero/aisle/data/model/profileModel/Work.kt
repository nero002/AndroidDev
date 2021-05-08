package com.nero.aisle.data.model.profileModel


import com.google.gson.annotations.SerializedName

data class Work(
    @SerializedName("experience")
    val experience: String?,
    @SerializedName("experience_v1")
    val experienceV1: ExperienceV1?,
    @SerializedName("field_of_study")
    val fieldOfStudy: String?,
    @SerializedName("field_of_study_v1")
    val fieldOfStudyV1: FieldOfStudyV1?,
    @SerializedName("highest_qualification")
    val highestQualification: String?,
    @SerializedName("highest_qualification_v1")
    val highestQualificationV1: HighestQualificationV1?,
    @SerializedName("industry")
    val industry: String?,
    @SerializedName("industry_v1")
    val industryV1: IndustryV1?,
    @SerializedName("monthly_income_v1")
    val monthlyIncomeV1: Any?
)