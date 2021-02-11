package com.example.exretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exretrofit.databinding.ItemNewsBinding

class NewsAdapter(private val newsList: ArrayList<Items>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(viewBinding: ItemNewsBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        private val title = viewBinding.titleText
        private val date = viewBinding.dateText

        fun bind(news: Items) {
            title.text = news.title
            date.text = news.pubDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = newsList[position]
        holder.bind(news)
    }

    override fun getItemCount(): Int = newsList.size
}