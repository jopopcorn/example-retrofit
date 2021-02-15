package com.example.exretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exretrofit.databinding.ItemNewsBinding

class NewsAdapter(private val newsList: ArrayList<Items>, private val onClick: (Items) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemNewsBinding, val onClick: (Items) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        private val title = binding.titleText
        private val date = binding.dateText
        private var currentNews: Items? = null

        init {
            itemView.setOnClickListener{
                currentNews?.let {
                    onClick(it)
                }
            }
        }

        fun bind(news: Items) {
            currentNews = news
            title.text = news.title
            date.text = news.pubDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = newsList[position]
        holder.bind(news)
    }

    override fun getItemCount(): Int = newsList.size
}