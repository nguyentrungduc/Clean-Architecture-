package com.example.cleanarchitecture.ui.newsfeed.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.cleanarchitecture.model.NewsFeedItem

class NewsFeedItemDiffCallback : DiffUtil.ItemCallback<NewsFeedItem>() {
    override fun areItemsTheSame(oldItem: NewsFeedItem, newItem: NewsFeedItem): Boolean {
        return oldItem.documentId == newItem.documentId && oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: NewsFeedItem, newItem: NewsFeedItem): Boolean {
        return oldItem.title == newItem.title
    }
}