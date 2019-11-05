package com.acp1.my.menu.data.repository

import android.content.Context
import com.acp1.my.menu.data.remote.ApiClient
import com.acp1.my.menu.data.remote.model.dto.MenuDto
import com.acp1.my.menu.data.remote.utils.NetworkConnectionException
import com.acp1.my.menu.data.remote.utils.NetworkHandler
import com.acp1.my.menu.data.remote.utils.Result
import com.acp1.my.menu.data.remote.utils.awaitResult
import com.acp1.my.menu.presentation.di.base.ApplicationContext
import javax.inject.Inject

class MyMenuRepository @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val services: ApiClient,
    @ApplicationContext val context: Context
) {

    //TODO: la cache deberia de ser de HomeDto, si llama a una nueva pagina se agregan los bloques
    // en la cache y se actualiza el paging. Si se llama a la pagina cero se limpia la cache
    // y se vuelve a guardar el HomeDto

    suspend fun getMenu(): Result<MenuDto> {
        return when (networkHandler.isConnected) {
            true -> {
                services.getMenu().awaitResult()
            }
            false, null -> Result.Exception(NetworkConnectionException())
        }
    }
/*
    suspend fun getBlockDetail(
        blockId: Int,
        page: Int = 0,
        count: Int = 10
    ): Result<BlockDetailDto> {
        return when (networkHandler.isConnected) {
            true -> {
                services.getBlockDetail(blockId, page.toString(), count.toString()).awaitResult()
            }
            false, null -> Result.Exception(NetworkConnectionException())
        }
    }

    suspend fun getRelatedContent(uuid: String): Result<RelatedDto> {
        return when (networkHandler.isConnected) {
            true -> {
                services.getRelatedContent(uuid).awaitResult()
            }
            false, null -> Result.Exception(NetworkConnectionException())
        }
    }

    suspend fun getPeopleMovies(
        slug: String,
        page: Int = 0,
        count: Int = 10
    ): Result<SlugMoviesDto> {
        return when (networkHandler.isConnected) {
            true -> {
                services.getPeopleMovies(slug, page.toString(), count.toString()).awaitResult()
            }
            false, null -> Result.Exception(NetworkConnectionException())
        }
    }*/
}