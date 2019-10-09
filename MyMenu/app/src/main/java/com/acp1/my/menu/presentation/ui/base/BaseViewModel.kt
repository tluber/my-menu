package com.acp1.my.menu.presentation.ui.base

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import com.acp1.my.menu.AppApplication
import com.acp1.my.menu.utils.Event

open class BaseViewModel : ViewModel() {

    protected val mDataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean>
        get() = mDataLoading

    private val mSnackBarText = MutableLiveData<Event<String>>()
    val snackBarMessage: LiveData<Event<String>>
        get() = mSnackBarText

    private val mToastText = MutableLiveData<Event<Int>>()
    val toastMessage: LiveData<Event<Int>>
        get() = mToastText

    protected val mShowLoginScreen = MutableLiveData<Event<Boolean>>()
    val showLoginScreen: LiveData<Event<Boolean>>
        get() = mShowLoginScreen

    protected fun showSnackbarMessage(message: String) {
        mSnackBarText.value = Event(message)
    }

    protected fun showSnackbarMessage(@StringRes resource: Int) {
        showSnackbarMessage(AppApplication.instance!!.getString(resource))
    }

    protected fun showToastMessage(message: String) {
        mSnackBarText.value = Event(message)
    }

    protected fun showToastMessage(@StringRes resource: Int) {
        showToastMessage(AppApplication.instance!!.getString(resource))
    }

}