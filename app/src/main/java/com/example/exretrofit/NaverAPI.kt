package com.example.exretrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NaverAPI {
    @GET("v1/search/news.json")
    fun getSearchNews(
        @Query("query") query: String,
        @Query("display") display: Int? = null,
        @Query("start") start: Int? = null
    ): Call<Result>
}