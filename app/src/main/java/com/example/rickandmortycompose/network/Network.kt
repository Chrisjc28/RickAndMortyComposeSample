package com.example.rickandmortycompose.network

import com.example.rickandmortycompose.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network: RetroFitInstance, RetroFitService {

    override fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun <S> createService(serviceClass: Class<S>?): S {
        return createRetrofit().create(serviceClass)
    }
}

interface RetroFitInstance {
    fun createRetrofit(): Retrofit
}

interface RetroFitService {
    fun <S> createService(serviceClass: Class<S>?) : S
}