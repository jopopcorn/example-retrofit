package com.example.exretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exretrofit.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "ArticleActivity"
    }

    private lateinit var binding: ActivityArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}