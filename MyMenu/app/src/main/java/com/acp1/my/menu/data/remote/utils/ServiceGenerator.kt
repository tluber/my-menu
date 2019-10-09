package com.acp1.my.menu.data.remote.utils

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.acp1.my.menu.BuildConfig
import com.acp1.my.menu.data.local.AppPreferences

class ServiceGenerator {

    companion object {

        private val mLogging = HttpLoggingInterceptor()
        private var mGsonFactory: GsonConverterFactory? = null
        private val mHttpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        private var mBuilder: Retrofit.Builder? = null

        fun <S> createService(serviceClass: Class<S>): S {

            mHttpClient.let {
                if (BuildConfig.DEBUG) {
                    mLogging.level = HttpLoggingInterceptor.Level.BODY
                    mHttpClient.addInterceptor(mLogging)
                    mHttpClient.addNetworkInterceptor(StethoInterceptor())
                }

                mHttpClient.addInterceptor { chain ->

                    val urlBuilder = chain.request().url().newBuilder()

                    AppPreferences.token?.let {
                        urlBuilder.addQueryParameter("api_token", it)
                    }

                    val url = urlBuilder.build()
                    val builder = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Content-type", "application/json")
                        .addHeader("Connection", "close")

                    AppPreferences.token?.let {
                        builder.addHeader("Authorization", it)
                    }

                    builder.url(url)
                    chain.proceed(builder.build())

                }

            }

            if (mGsonFactory == null) {

                val gson = GsonBuilder().create()
                mGsonFactory = GsonConverterFactory
                    .create(gson)
            }


            mBuilder = Retrofit.Builder()
                .baseUrl(BuildConfig.HOST)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(mGsonFactory)


            val client = mHttpClient.build()
            val retrofit = mBuilder!!.client(client).build()
            return retrofit.create(serviceClass)
        }

    }


}