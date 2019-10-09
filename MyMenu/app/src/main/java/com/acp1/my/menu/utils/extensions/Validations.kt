package com.acp1.my.menu.utils.extensions

import android.util.Patterns
import java.util.regex.Pattern


fun String.isEmailValid(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isPasswordValid(): Boolean {
    return this.length >= 6
}

fun String.isPhoneNumberValid(): Boolean {
    return this.isNotEmpty() && Patterns.PHONE.matcher(this).matches()
}

fun String.isFirstNameValid(): Boolean {
    return this.isNotEmpty() && Pattern.matches("^[a-zA-Z]+\$", this)
}

fun String.isLastNameValid(): Boolean {
    return this.isNotEmpty() && Pattern.matches("^[a-zA-Z]+\$", this)
}

fun String.isConfirmPasswordValid(password: String): Boolean {
    return password == this
}
