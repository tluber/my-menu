package com.acp1.my.menu.presentation.ui.access

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.acp1.my.menu.R
import com.acp1.my.menu.data.local.model.Category
import com.acp1.my.menu.data.remote.utils.NetworkConnectionException
import com.acp1.my.menu.data.repository.MyMenuRepository
import com.acp1.my.menu.data.remote.utils.Result
import com.acp1.my.menu.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyMenuViewModel
@Inject constructor(private val myMenuRepository: MyMenuRepository) : BaseViewModel() {

    private val TAG: String = "MY_MENU_VM"

    private val mMenu = MutableLiveData<List<Category>>()
    val menu: LiveData<List<Category>> = mMenu

    fun getMovieDetail() {

        mDataLoading.value = true
        viewModelScope.launch {
            when (val result = myMenuRepository.getMenu()) {
                // Successful HTTP result
                is Result.Ok -> {
                    //mMenu.value = result.value.
                }
                // Any HTTP error
                is Result.Error -> {

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