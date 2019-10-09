package com.acp1.my.menu.utils.extensions

inline fun < reified T> Boolean?.ifTrue(statements: ()->T){
    if(this == true)
        statements()
}

inline fun < reified T> Boolean?.ifFalse(statements: ()->T){
    if(this == false)
        statements()
}

fun Boolean.toInt(): Int{
    return when(this){
        true -> 1
        false -> 0
    }
}