package com.nero.aisle.viewModel

import androidx.lifecycle.*
import com.nero.aisle.data.model.PhoneNumber
import com.nero.aisle.data.model.Token
import com.nero.aisle.data.model.profileModel.ProfileResponseModel
import com.nero.aisle.repository.AisleRepository
import com.nero.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel

class AisleViewModel @Inject constructor(val aisleRepository: AisleRepository) : ViewModel() {

    val status = MutableLiveData<Boolean?>(null)
    val loadError = MutableLiveData<String>("")
    val isLoading = MutableLiveData<Boolean>(false)


    fun phoneNumber(phoneNumber: PhoneNumber) {
        viewModelScope.launch {

            isLoading.value = true

            val result = aisleRepository.getStatus(phoneNumber)
            when (result) {
                is Resource.Success -> {
                    status.value = result.data?.status == true
                    isLoading.value = false
                }
                is Resource.Error -> {

                    loadError.value = result.message ?: "Unknown error"
                    isLoading.value = false
                }

            }
        }

    }

    var tokenLiveData = MutableLiveData<String?>(null)
    val isValid = MutableLiveData<Boolean?>(null)

    fun otpToken(token: Token) {
        viewModelScope.launch {
            isLoading.value = true

            val result = aisleRepository.getOTP(token)

            when (result) {
                is Resource.Success -> {

                    if (result.data?.token != null) {
                        tokenLiveData.value = result.data.token
                        isValid.value = true
                    } else {
                        isValid.value = false
                    }
                }
                is Resource.Error -> {

                    loadError.value = result.message ?: "Unknown OTP Wrong"
                    isLoading.value = false
                }
            }
        }
    }


    var profileData = MutableLiveData<ProfileResponseModel>(null)

    fun profile(profileToken: String): LiveData<Resource<ProfileResponseModel>> {
//        viewModelScope.launch {
//            val result = aisleRepository.getProfile(profileToken)
//
//            when (result) {
//                is Resource.Success -> {
//                    profileData.value = result.data!!
//                }
//                is Resource.Error -> {
//
//                    loadError.value = result.message ?: "Unknown error"
//                    isLoading.value = false
//                }
//            }
//
//        }

        return liveData(Dispatchers.IO) {
            val result = aisleRepository.getProfile(profileToken)
            emit(result)
        }


    }


}