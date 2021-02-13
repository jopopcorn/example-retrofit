package com.example.exretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exretrofit.databinding.ActivityMainBinding
import okhttp3.internal.notify
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    companion object{
        private const val TAG = "MainActivity"
    }

    private lateinit var retrofit: Retrofit
    private lateinit var api: NaverAPI
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var newsAdapter: NewsAdapter
    private var newsList: ArrayList<Items> = arrayListOf()
    private lateinit var queryMessage : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRetrofit()
        initRecyclerView()

        binding.searchBtn.setOnClickListener {
            queryMessage = binding.searchEdit.text.toString()
            newsList.clear()
            search(queryMessage)
        }
    }

    private fun search(query: String) {
        api.getSearchNews(query).enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                if (response.code() == 200 && response.body() != null) {
                    val result : Result = response.body()!!
                    newsList.addAll(result.items)
                    newsAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                Log.d(TAG, "${t.message}")
            }
        })
    }


    private fun initRecyclerView() {
        viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        newsAdapter = NewsAdapter(newsList)
        binding.recyclerView.apply {
            layoutManager = viewManager
            adapter = newsAdapter
            setHasFixedSize(true)
        }
    }

    private fun initRetrofit() {
        retrofit = RetrofitClient.getInstance()
        api = retrofit.create(NaverAPI::class.java)
    }
}