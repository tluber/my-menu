package com.acp1.my.menu.presentation.ui.suggest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.acp1.my.menu.R
import com.acp1.my.menu.data.remote.utils.NetworkConnectionException
import com.acp1.my.menu.data.remote.utils.Result
import com.acp1.my.menu.data.repository.MyMenuRepository
import com.acp1.my.menu.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class SuggestionViewModel
@Inject constructor(private val myMenuRepository: MyMenuRepository) : BaseViewModel() {

    private val TAG: String = "SUGGESTION_VM"

    private val mSuccess = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = mSuccess

    fun makeSuggestion(name: String, email: String, suggest: String) {

        mDataLoading.value = true
        viewModelScope.launch {
            when (val result = myMenuRepository.makeSuggestion(name, email, suggest)) {
                // Successful HTTP result
                is Result.Ok -> {
                    showSnackbarMessage(R.string.suggestion_recorded)
                    mSuccess.value = true
                }
                // Any HTTP error
                is Result.Error -> {
                    when (result.exception.code()) {
                        400 -> showSnackbarMessage(R.string.bad_request_email)
                        else -> showSnackbarMessage(R.string.error_unexpected)
                    }
                }
                // Exception while request invocation
                is Result.Exception -> {
                    when (result.exception) {
                        is NetworkConnectionException -> showSnackbarMessage(R.string.error_no_internet)
                        else -> showSnackbarMessage(R.string.error_unexpected)
                    }
                }
            }
            mDataLoading.value = false
        }
    }
}