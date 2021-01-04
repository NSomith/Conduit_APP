package com.example.conduit.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.api.module.entities.Article
import com.example.conduit.databinding.ListItemArticleBinding

class ArticleFeedAdapter: ListAdapter<Article,ArticleFeedAdapter.ArticleViewHolder>(
    object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
           return oldItem.toString() == newItem.toString()
        }

    }
) {

    inner class ArticleViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ListItemArticleBinding.inflate(
            parent.context.getSystemService(LayoutInflater::class.java),
            parent,
            false
        )
        return ArticleViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        ListItemArticleBinding.bind(holder.itemView).apply {
            val article = getItem(position)
            authortextview.text = article.author.username
            titletextview.text = article.title
            bodysnipettextview.text = article.body
        }
    }
}