package com.acp1.my.menu.utils.extensions

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.View
import com.acp1.my.menu.R

fun Activity.sendEmail(email: String, subject: String = "", mainView: View){
    val intent = Intent(Intent.ACTION_SENDTO)
    intent.data = Uri.parse("mailto:")
    intent.putExtra(Intent.EXTRA_EMAIL, email)
    intent.putExtra(Intent.EXTRA_SUBJECT, subject)

    try {
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        mainView.showSnackbar(R.string.error_email_app_not_available)
    }
}

fun Activity.openUrl(url: String, mainView: View){

    var path = url
    if(!path.contains("http://", ignoreCase = true) && !path.contains("https://", ignoreCase = true)){
        path = "http://"+url
    }

    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(path))
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        mainView.showSnackbar(R.string.error_web_app_not_available)
    }
}

fun Activity.call(phone: String, mainView: View){
    val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
    startActivity(intent)

    try {
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        mainView.showSnackbar(R.string.error_phone_app_not_available)
    }
}


