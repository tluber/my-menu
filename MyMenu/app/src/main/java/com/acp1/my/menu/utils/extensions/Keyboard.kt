package com.acp1.my.menu.utils.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(if (currentFocus == null) View(this) else currentFocus)
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

enum class KeyboardStatus {
    OPEN, CLOSED
}

class KeyboardLiveData : LiveData<KeyboardStatus>() {

    private fun getActivity(owner: LifecycleOwner): Activity? {
        var activity: Activity? = null
        when (owner) {
            is Activity -> activity = owner
            is Fragment -> activity = owner.activity
            else -> activity = null
        }
        return activity
    }

    private var rootView: ViewGroup? = null

    private val globalLayoutListener = ViewTreeObserver.OnGlobalLayoutListener {

        rootView?.apply {
            val r = Rect()
            getWindowVisibleDisplayFrame(r)

            val heightDiff = rootView.height - (r.bottom - r.top)
            value = if (heightDiff > 350) {
                KeyboardStatus.OPEN
            } else {
                KeyboardStatus.CLOSED
            }
        }

    }

    override fun observe(owner: LifecycleOwner, observer: Observer<in KeyboardStatus>) {
        super.observe(owner, observer)

        val activity: Activity? = getActivity(owner)

        if (activity != null) {
            rootView = activity.findViewById(android.R.id.content)
            rootView?.apply {
                viewTreeObserver.addOnGlobalLayoutListener(globalLayoutListener)
            }
        }
    }

    override fun removeObservers(owner: LifecycleOwner) {
        super.removeObservers(owner)

        getActivity(owner)?.apply {
            val rootView: ViewGroup? = findViewById(android.R.id.content)
            rootView?.apply {
                viewTreeObserver.removeOnGlobalLayoutListener(globalLayoutListener)
            }
        }

    }
}