package com.acp1.my.menu.data.remote.model.dto

import com.acp1.my.menu.utils.extensions.append
import java.io.Serializable

data class UserDto (

    val id : Int,
    val firstName : String?,
    val lastName : String?,
    val email : String
) : Serializable{

    val fullName:String
        get() = firstName.append(lastName, " ")
}