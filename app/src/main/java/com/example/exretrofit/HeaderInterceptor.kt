package com.example.exretrofit

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val origin = chain.request()
        val request = origin.newBuilder()
            .addHeader("X-Naver-Client-Id", "YOUR_CLIENT_ID")
            .addHeader("X-Naver-Client-Secret", "YOUR_CLIENT_SECRET")
            .build()

        return chain.proceed(request)
    }
}