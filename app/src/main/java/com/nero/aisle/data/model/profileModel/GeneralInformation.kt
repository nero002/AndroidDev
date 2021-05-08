package com.nero.aisle.data.model.profileModel


import com.google.gson.annotations.SerializedName

data class GeneralInformation(
    @SerializedName("age")
    val age: Int?,
    @SerializedName("cast")
    val cast: Any?,
    @SerializedName("date_of_birth")
    val dateOfBirth: String?,
    @SerializedName("date_of_birth_v1")
    val dateOfBirthV1: String?,
    @SerializedName("diet")
    val diet: Any?,
    @SerializedName("drinking")
    val drinking: String?,
    @SerializedName("drinking_v1")
    val drinkingV1: DrinkingV1?,
    @SerializedName("faith")
    val faith: Faith?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("kid")
    val kid: Any?,
    @SerializedName("location")
    val location: Location?,
    @SerializedName("marital_status")
    val maritalStatus: String?,
    @SerializedName("marital_status_v1")
    val maritalStatusV1: MaritalStatusV1?,
    @SerializedName("mother_tongue")
    val motherTongue: MotherTongue?,
    @SerializedName("pet")
    val pet: Any?,
    @SerializedName("politics")
    val politics: Any?,
    @SerializedName("ref_id")
    val refId: String?,
    @SerializedName("settle")
    val settle: Any?,
    @SerializedName("smoking")
    val smoking: String?,
    @SerializedName("smoking_v1")
    val smokingV1: SmokingV1?,
    @SerializedName("sun_sign")
    val sunSign: String?,
    @SerializedName("sun_sign_v1")
    val sunSignV1: SunSignV1?
)