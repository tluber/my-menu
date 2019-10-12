package com.acp1.my.menu.data.remote.utils

import com.acp1.my.menu.BuildConfig
import com.acp1.my.menu.data.local.AppPreferences
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ServiceGenerator {

    companion object {

        private val mLogging = HttpLoggingInterceptor()
        private var mMoshiFactory: MoshiConverterFactory? = null
        private var mBuilder: Retrofit.Builder? = null

        fun <S> createService(serviceClass: Class<S>): S {

            val httpClient = OkHttpClient.Builder()
            httpClient.apply {
                if (BuildConfig.DEBUG) {
                    mLogging.level = HttpLoggingInterceptor.Level.BODY
                    addInterceptor(mLogging)
                    addNetworkInterceptor(StethoInterceptor())
                }

                addInterceptor { chain ->

                    val builder = chain.request().newBuilder()
                        .header("Accept", "application/json")
                        .header("Content-type", "application/json")
                        .header("Connection", "close")

                    AppPreferences.token?.let {
                        builder.header("Authorization", it)
                    }

                    chain.proceed(builder.build())
                }
            }

            if (mMoshiFactory == null) {
                var moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                mMoshiFactory = MoshiConverterFactory.create(moshi.build())
            }

            mBuilder = Retrofit.Builder()
                .baseUrl(BuildConfig.HOST)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(mMoshiFactory)

            val client = httpClient.build()
            val retrofit = mBuilder!!.client(client).build()
            return retrofit.create(serviceClass)
        }
    }
}