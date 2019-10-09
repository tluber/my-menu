package com.acp1.my.menu.utils.extensions


inline fun String?.append(text: String?, separator: String = ", "): String {

    if (this.isNullOrBlank()) {
        return text ?: ""
    }

    if (text.isNullOrBlank()) {
        return this
    }

    return "$this$separator$text"
}

inline fun String?.appendAll(vararg list: String?, separator: String = ", "): String {

    val strings = mutableListOf<String>()

    if (this != null) {
        strings.add(this)
    }

    for (str in list) {
        if (!str.isNullOrBlank()) {
            strings.add(str)
        }
    }

    return strings.joinToString(separator = separator)
}

