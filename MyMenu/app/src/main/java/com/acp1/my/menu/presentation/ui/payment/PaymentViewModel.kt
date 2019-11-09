package com.acp1.my.menu.presentation.ui.payment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.acp1.my.menu.R
import com.acp1.my.menu.data.local.model.Payment
import com.acp1.my.menu.data.mapper.toPayment
import com.acp1.my.menu.data.remote.utils.NetworkConnectionException
import com.acp1.my.menu.data.remote.utils.Result
import com.acp1.my.menu.data.repository.MyMenuRepository
import com.acp1.my.menu.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class PaymentViewModel
@Inject constructor(private val myMenuRepository: MyMenuRepository) : BaseViewModel() {

    private val TAG: String = "PAYMENT_VM"

    private val mPayments = MutableLiveData<List<Payment>>()
    val payments: LiveData<List<Payment>> = mPayments

    fun getPayments() {

        mDataLoading.value = true
        viewModelScope.launch {
            when (val result = myMenuRepository.getPayments()) {
                // Successful HTTP result
                is Result.Ok -> {
                    mPayments.value = result.value.map { it.toPayment() }
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