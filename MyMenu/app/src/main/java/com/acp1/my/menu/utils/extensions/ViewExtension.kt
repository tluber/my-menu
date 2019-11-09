package com.acp1.my.menu.utils.extensions

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.acp1.my.menu.R
import com.acp1.my.menu.utils.Event


fun View.makeSnackbar(
    backgroundColor: Int,
    title: String,
    titleColor: Int,
    timeLength: Int = Snackbar.LENGTH_LONG
): Snackbar {
    val snackbarText = SpannableStringBuilder()

    snackbarText.append(title)
    snackbarText.setSpan(
        ForegroundColorSpan(ContextCompat.getColor(this.context, titleColor)),
        0,
        snackbarText.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    val snackbar = Snackbar.make(this, snackbarText, timeLength)
    snackbar.view.setBackgroundColor(ContextCompat.getColor(this.context, backgroundColor))
    snackbar.setActionTextColor(ContextCompat.getColor(this.context, R.color.colorPrimary))

    return snackbar
}

fun View.makeErrorSnackbar(@StringRes title: Int, timeLength: Int = Snackbar.LENGTH_LONG): Snackbar {
    return makeErrorSnackbar(this.context.getString(title), timeLength)
}

fun View.makeErrorSnackbar(title: String, timeLength: Int = Snackbar.LENGTH_LONG): Snackbar {
    return makeSnackbar(R.color.colorRed, title, R.color.colorWhite, timeLength)
}

fun View.makeSucessfulSnackbar(@StringRes title: Int, timeLength: Int = Snackbar.LENGTH_LONG): Snackbar {
    return makeSucessfulSnackbar(this.context.getString(title), timeLength)
}

fun View.makeSucessfulSnackbar(title: String, timeLength: Int = Snackbar.LENGTH_LONG): Snackbar {
    return makeSnackbar(R.color.colorGreen, title, R.color.colorWhite, timeLength)
}

fun View.makeSnackbar(@StringRes title: Int, timeLength: Int = Snackbar.LENGTH_LONG): Snackbar {
    return makeSnackbar(this.context.getString(title), timeLength)
}

fun View.makeSnackbar(title: String, timeLength: Int = Snackbar.LENGTH_LONG): Snackbar {
    return makeSnackbar(R.color.colorWhite, title, R.color.colorBlack, timeLength)
}


fun View.showSnackbar(snackbarText: String, timeLength: Int = Snackbar.LENGTH_LONG) {
    this.makeSnackbar(snackbarText, timeLength).show()
}

fun View.showSnackbar(@StringRes message: Int, timeLength: Int = Snackbar.LENGTH_LONG) {
    this.makeSnackbar(message, timeLength).show()
}


/**
 * Triggers a snackbar message when the value contained by snackbarTaskMessageLiveEvent is modified.
 */
fun View.setupSnackbarRes(
    lifecycleOwner: LifecycleOwner,
    snackbarEvent: LiveData<Event<Int>>,
    timeLength: Int
) {

    snackbarEvent.observe(lifecycleOwner, Observer { event ->
        event.getContentIfNotHandled()?.let {
            showSnackbar(context.getString(it), timeLength)
        }
    })
}

fun View.setupSnackbar(
    lifecycleOwner: LifecycleOwner,
    snackbarEvent: LiveData<Event<String>>,
    timeLength: Int
) {

    snackbarEvent.observe(lifecycleOwner, Observer { event ->
        event.getContentIfNotHandled()?.let {
            showSnackbar(it, timeLength)
        }
    })
}

//TOAST
fun View.showToast(text: String, timeLength: Int) {
    Toast.makeText(context, text, timeLength).show()
}

fun View.setupToast(
    lifecycleOwner: LifecycleOwner,
    toastEvent: LiveData<Event<Int>>,
    timeLength: Int
) {

    toastEvent.observe(lifecycleOwner, Observer { event ->
        event.getContentIfNotHandled()?.let {
            showToast(context.getString(it), timeLength)
        }
    })
}

// ANIMATE VISIBILITY
fun View.visible(animate: Boolean = true) {
    if (animate) {
        animate().alpha(1f).setDuration(300).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                visibility = View.VISIBLE
            }
        })
    } else {
        visibility = View.VISIBLE
    }
}

/** Set the View visibility to INVISIBLE and eventually animate view alpha till 0% */
fun View.invisible(animate: Boolean = true) {
    hide(View.INVISIBLE, animate)
}

/** Set the View visibility to GONE and eventually animate view alpha till 0% */
fun View.gone(animate: Boolean = true) {
    hide(View.GONE, animate)
}

private fun View.hide(hidingStrategy: Int, animate: Boolean = true) {
    if (animate) {
        animate().alpha(0f).setDuration(300).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                visibility = hidingStrategy
            }
        })
    } else {
        visibility = hidingStrategy
    }
}
