package com.acp1.my.menu.data.remote.model.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MenuDto(
    @Json(name = "categorias") val categories: List<CategoryDto>
)

@JsonClass(generateAdapter = true)
data class CategoryDto(
    @Json(name = "id") val id: Int,
    @Json(name = "nombre") val name: String,
    @Json(name = "platos") val dishes: List<DishDto>
)

@JsonClass(generateAdapter = true)
data class DishDto(
    @Json(name = "id") val id: Int,
    @Json(name = "nombre") val name: String,
    @Json(name = "imagen") val picture: String,
    @Json(name = "precio") val price: String,
    @Json(name = "descripcion") val description: String,
    @Json(name = "filtros") val filters: List<FilterDto>
)

@JsonClass(generateAdapter = true)
data class FilterDto(
    @Json(name = "id") val id: Int,
    @Json(name = "nombre") val name: String
)

@JsonClass(generateAdapter = true)
data class PromotionsDto(
    @Json(name = "promociones") val promotions: List<PromotionDto>
)

@JsonClass(generateAdapter = true)
data class PromotionDto(
    @Json(name = "id") val id: Int,
    @Json(name = "nombre") val name: String,
    @Json(name = "descripcion") val description: String
)

@JsonClass(generateAdapter = true)
data class PaymentDto(
    @Json(name = "id") val id: Int,
    @Json(name = "nombre") val name: String,
    @Json(name = "imagen") val picture: String
)

@JsonClass(generateAdapter = true)
data class TodayMenuDto(
    @Json(name = "entrada") val starter: OptionDto,
    @Json(name = "plato-principal") val main: OptionDto,
    @Json(name = "precio") val price: String,
    @Json(name = "postre") val dessert: OptionDto,
    @Json(name = "cafe") val hasCoffee: Boolean,
    @Json(name = "opciones") val options: String
)

@JsonClass(generateAdapter = true)
data class OptionDto(
    @Json(name = "id") val id: Int,
    @Json(name = "nombre") val name: String
)