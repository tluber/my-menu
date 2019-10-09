package com.acp1.my.menu.data.local.model

import androidx.annotation.StringRes

data class LoginFormState(
    @StringRes var emailError: Int? = null,
    @StringRes var passwordError: Int? = null,
    var isDataValid: Boolean = false
)