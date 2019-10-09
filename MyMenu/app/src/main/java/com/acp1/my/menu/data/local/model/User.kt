package com.acp1.my.menu.data.local.model

import com.acp1.my.menu.utils.extensions.append

data class User (

    val id : Int,
    val firstName : String?,
    val lastName : String?,
    val email : String
){

    val fullName:String
        get() = firstName.append(lastName, " ")
}