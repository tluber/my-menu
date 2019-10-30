package com.acp1.my.menu.data.remote.model.dto

import com.acp1.my.menu.data.remote.model.ApiResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MenuDto(
    @Json(name = "status") override val status: String,
    @Json(name = "message") val categories: List<CategoryDto>
) : ApiResponse()

@JsonClass(generateAdapter = true)
data class CategoryDto(
    @Json(name = "id") val id: String,
    @Json(name = "nombre") val name: String,
    @Json(name = "platos") val dishes: List<DishDto>
)

@JsonClass(generateAdapter = true)
data class DishesDto(
    @Json(name = "status") override val status: String,
    @Json(name = "id") val id: String,
    @Json(name = "nombre") val name: String,
    @Json(name = "imagen") val picture: String,
    @Json(name = "precio") val price: String,
    @Json(name = "filtros") val filters: List<FilterDto>?
) : ApiResponse()

@JsonClass(generateAdapter = true)
data class DishDto(
    @Json(name = "id") val id: String,
    @Json(name = "nombre") val name: String,
    @Json(name = "imagen") val picture: String,
    @Json(name = "precio") val price: String
)

@JsonClass(generateAdapter = true)
data class FiltersDto(
    @Json(name = "status") override val status: String,
    @Json(name = "filtros") val filters: List<FilterDto>?
) : ApiResponse()

@JsonClass(generateAdapter = true)
data class FilterDto(
    @Json(name = "id") val id: String,
    @Json(name = "nombre") val name: String
)

@JsonClass(generateAdapter = true)
data class PromotionsDto(
    @Json(name = "status") override val status: String,
    @Json(name = "promociones") val promotions: List<PromotionDto>
) : ApiResponse()

@JsonClass(generateAdapter = true)
data class PromotionDto(
    @Json(name = "id") val id: String,
    @Json(name = "nombre") val name: String,
    @Json(name = "descripcion") val description: String
)

@JsonClass(generateAdapter = true)
data class PaymentsDto(
    @Json(name = "status") override val status: String,
    @Json(name = "medios-de-pago") val payments: List<PaymentDto>
) : ApiResponse()

@JsonClass(generateAdapter = true)
data class PaymentDto(
    @Json(name = "id") val id: String,
    @Json(name = "nombre") val name: String,
    @Json(name = "imagen") val picture: String
)

@JsonClass(generateAdapter = true)
data class TodayMenuDto(
    @Json(name = "status") override val status: String,
    @Json(name = "entrada") val starter: OptionDto,
    @Json(name = "plato-principal") val main: OptionDto,
    @Json(name = "precio") val price: String,
    @Json(name = "postre") val dessert: OptionDto,
    @Json(name = "cafe") val hasCoffee: Boolean,
    @Json(name = "opciones") val options: String
) : ApiResponse()

@JsonClass(generateAdapter = true)
data class OptionDto(
    @Json(name = "id") val id: String,
    @Json(name = "nombre") val name: String
)