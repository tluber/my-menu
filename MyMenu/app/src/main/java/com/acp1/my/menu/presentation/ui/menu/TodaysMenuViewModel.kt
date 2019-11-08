package com.acp1.my.menu.presentation.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.acp1.my.menu.R
import com.acp1.my.menu.data.local.model.TodaysMenu
import com.acp1.my.menu.data.mapper.toTodaysMenu
import com.acp1.my.menu.data.remote.utils.NetworkConnectionException
import com.acp1.my.menu.data.remote.utils.Result
import com.acp1.my.menu.data.repository.MyMenuRepository
import com.acp1.my.menu.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class TodaysMenuViewModel
@Inject constructor(private val myMenuRepository: MyMenuRepository) : BaseViewModel() {

    private val TAG: String = "TODAYS_MENU_VM"

    private val mMenu = MutableLiveData<TodaysMenu>()
    val menu: LiveData<TodaysMenu> = mMenu

    fun getTodaysMenu() {

        mDataLoading.value = true
        viewModelScope.launch {
            when (val result = myMenuRepository.getTodaysMenu()) {
                // Successful HTTP result
                is Result.Ok -> {
                    mMenu.value = result.value.toTodaysMenu()
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