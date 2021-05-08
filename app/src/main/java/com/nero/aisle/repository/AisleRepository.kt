package com.nero.aisle.repository

import com.nero.aisle.data.model.PhoneNumber
import com.nero.aisle.data.model.StatusResponseModel
import com.nero.aisle.data.model.Token
import com.nero.aisle.data.model.TokenResponseModel
import com.nero.aisle.data.model.profileModel.ProfileResponseModel
import com.nero.aisle.data.remote.AisleClient
import com.nero.util.Resource
import javax.inject.Inject

class AisleRepository @Inject constructor(val aisleClient: AisleClient) {

    suspend fun getStatus(phoneNumber: PhoneNumber): Resource<StatusResponseModel> {
        val response = try {
            aisleClient.phoneNumber(phoneNumber)
        } catch (e: Exception) {
            return Resource.Error("${e.localizedMessage}")
        }
        return Resource.Success(response)
    }


    suspend fun getOTP(token: Token): Resource<TokenResponseModel> {
        val response = try {
            aisleClient.token(token)
        } catch (e: Exception) {
            return Resource.Error("${e.localizedMessage}")
        }
        return Resource.Success(response)
    }

    suspend fun getProfile(
        authorization: String
    ): Resource<ProfileResponseModel> {
        val response = try {
            aisleClient.profiles(authorization)
        } catch (e: Exception) {
            return Resource.Error("${e.localizedMessage}")
        }
        return Resource.Success(response)
    }

}