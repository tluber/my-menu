package com.acp1.my.menu.presentation.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.acp1.my.menu.R
import com.acp1.my.menu.data.local.model.Category
import com.acp1.my.menu.data.mapper.toCategory
import com.acp1.my.menu.data.remote.utils.NetworkConnectionException
import com.acp1.my.menu.data.remote.utils.Result
import com.acp1.my.menu.data.repository.MyMenuRepository
import com.acp1.my.menu.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel
@Inject constructor(private val myMenuRepository: MyMenuRepository) : BaseViewModel() {

    private val TAG: String = "MENU_VM"

    private val mCategory = MutableLiveData<List<Category>>()
    val category: LiveData<List<Category>> = mCategory

    fun getMenu() {

        mDataLoading.value = true
        viewModelScope.launch {
            when (val result = myMenuRepository.getMenu()) {
                // Successful HTTP result
                is Result.Ok -> {
                    mCategory.value = result.value.categories.map { it.toCategory() }
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