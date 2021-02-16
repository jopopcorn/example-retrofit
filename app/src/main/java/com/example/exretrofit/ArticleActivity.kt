package com.example.exretrofit

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
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

        if(intent.hasExtra("url")){
            val link = intent.extras?.get("url").toString()
            binding.webView.apply {
                webViewClient = ProgressWebView()
                loadUrl(link)
            }
        }
    }

    inner class ProgressWebView(): WebViewClient(){

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            binding.progressBar.visibility = View.VISIBLE
            binding.webView.visibility = View.INVISIBLE
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            binding.progressBar.visibility = View.GONE
            binding.webView.visibility = View.VISIBLE
        }
    }
}