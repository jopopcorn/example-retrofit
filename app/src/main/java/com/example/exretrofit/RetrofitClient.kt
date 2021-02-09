package com.example.exretrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var instance : Retrofit?= null
    private const val BASE_URL = "https://openapi.naver.com"

    fun getInstance() : Retrofit{
        if(instance == null){
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HeaderInterceptor())
                .build()

            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance!!
    }

}