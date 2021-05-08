package com.nero.aisle.data.remote

import com.nero.aisle.data.model.PhoneNumber
import com.nero.aisle.data.model.StatusResponseModel
import com.nero.aisle.data.model.Token
import com.nero.aisle.data.model.TokenResponseModel
import com.nero.aisle.data.model.profileModel.ProfileResponseModel
import retrofit2.http.*


interface AisleClient {

    //1. Send Phone Number API
    @Headers("Content-Type: application/json")
    @POST("phone_number_login")
    suspend fun phoneNumber(@Body phoneNumberModel: PhoneNumber): StatusResponseModel

    //    2. Verify OTP API
    @POST("verify_otp")
    suspend fun token(@Body token: Token): TokenResponseModel

    //3. Fetch Profile list API
    @GET("test_profile_list")
    suspend fun profiles(
        @Header("Authorization") authorization: String
    ): ProfileResponseModel
}