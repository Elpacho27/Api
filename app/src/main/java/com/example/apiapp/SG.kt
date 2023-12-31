package com.example.apiapp

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SG {

    private val client= OkHttpClient.Builder().build()

    private val retrofit= Retrofit.Builder()
        .baseUrl("https://randomfox.ca/floof/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>):T{
        return retrofit.create(service)
    }
}