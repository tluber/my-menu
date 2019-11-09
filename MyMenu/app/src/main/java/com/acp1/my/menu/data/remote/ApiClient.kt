package com.acp1.my.menu.data.remote

import com.acp1.my.menu.data.remote.model.dto.*
import com.acp1.my.menu.data.remote.model.request.SuggestRequest
import retrofit2.Call
import retrofit2.http.*

interface ApiClient {

    @GET("/carta")
    fun getMenu(): Call<MenuDto>

    @GET("/plato/{id}")
    fun getDish(@Path("id") id: String): Call<DishDto>

    @GET("/filtro")
    fun getFilters(): Call<List<FilterDto>>

    @GET("/medio-de-pago")
    fun getPayments(): Call<List<PaymentDto>>

    @GET("/promocion")
    fun getPromotions(): Call<PromotionsDto>

    @GET("/menu-del-dia")
    fun getTodaysMenu(): Call<List<TodayMenuDto>>

    @POST("/sugerencia/")
    fun makeSuggestion(@Body body: SuggestRequest): Call<SuggestDto>
}