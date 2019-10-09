package com.acp1.my.menu.data.local

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.acp1.my.menu.data.remote.model.dto.UserDto

object AppPreferences {
    private const val NAME = "Qubit"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private const val USER_KEY = "User_v1"
    private const val TOKEN_KEY = "TOKEN_v1"

    fun init(context: Context) {
        preferences = context.getSharedPreferences(
            NAME,
            MODE
        )
    }

    var user: UserDto?
        get(): UserDto? {
            return when (val it = preferences.getString(USER_KEY, null)) {
                null -> null
                else -> Gson().fromJson(it, UserDto::class.java)
            }
        }
        set(value) {
            val editor = preferences.edit()
            when (value) {
                null -> editor.remove(USER_KEY)
                else -> {
                    val json = Gson().toJson(value)
                    editor.putString(USER_KEY, json)
                }
            }
            editor.apply()
        }


    var token: String?
        get(): String? {
            return preferences.getString(TOKEN_KEY, null)
        }
        set(value) {
            val editor = preferences.edit()
            editor.putString(TOKEN_KEY, value)
            editor.apply()
        }

    fun updateSession(user: UserDto?) {
        this.user = user
      //  this.token = this.user?.apiToken
    }

    fun clearSession() {
        this.user = null
        this.token = null
    }

}