package com.example.exretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private lateinit var retrofit: Retrofit
    private lateinit var api: NaverAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRetrofit()

        api.getSearchNews("설날").enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                Log.d("MainActivity", "응답 -> ${response.raw()}")
                if (response.code() == 200) {
                    val result = response.body()
                    Log.d("MainActivity", "result: ${result.toString()}")
                }
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                Log.d("MainActivity", "${t.message}")
            }

        })
    }

    private fun initRetrofit() {
        retrofit = RetrofitClient.getInstance()
        api = retrofit.create(NaverAPI::class.java)
    }
}