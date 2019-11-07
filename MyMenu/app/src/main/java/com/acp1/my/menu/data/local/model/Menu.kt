package com.acp1.my.menu.data.local.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val id: Int,
    val title: String,
    val items: List<Dish>
) : Parcelable

@Parcelize
data class Dish(
    val id: Int,
    val name: String,
    val price: String,
    val description: String,
    val picture: String,
    val filters: List<Filter>
) : Parcelable

@Parcelize
data class TodaysMenu(
    val starter: String,
    val main: String,
    val price: String,
    val hasDessert: Boolean,
    val hasCoffee: Boolean,
    val options: String
) : Parcelable

@Parcelize
data class Payment(
    val id: Int,
    val name: String,
    val picture: String
) : Parcelable

@Parcelize
data class Filter(
    val id: Int,
    val name: String
) : Parcelable