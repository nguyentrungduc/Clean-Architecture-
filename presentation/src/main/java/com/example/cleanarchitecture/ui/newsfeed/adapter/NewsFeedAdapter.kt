package com.example.cleanarchitecture.ui.newsfeed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cleanarchitecture.base.BaseViewHolder
import com.example.cleanarchitecture.databinding.ItemNewsFeedBinding
import com.example.cleanarchitecture.databinding.ItemNewsFeedType1Binding
import com.example.cleanarchitecture.databinding.ItemNewsFeedType2Binding
import com.example.cleanarchitecture.model.ImageItem
import com.example.cleanarchitecture.model.NewsFeedItem
import com.google.android.material.tabs.TabLayoutMediator

class NewsFeedAdapter(private val callback: ((NewsFeedItem) -> Unit)?
) :
    ListAdapter<NewsFeedItem, BaseViewHolder<NewsFeedItem>>(NewsFeedItemDiffCallback()) {

    companion object {
        const val NEWSFEED_TYPE = 0
        const val NEWSFEED_TYPE_1 = 1
        const val NEWSFEED_TYPE_2 = 2
    }

    override fun getItemViewType(position: Int): Int {
        return position % 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        NEWSFEED_TYPE -> NewsFeedViewHolder(
            ItemNewsFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        NEWSFEED_TYPE_1 -> NewsFeedType1ViewHolder(
            ItemNewsFeedType1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        NEWSFEED_TYPE_2 -> NewsFeedType2ViewHolder(
            ItemNewsFeedType2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        else ->
            throw NullPointerException("View holder for type $viewType not found")
    }

    override fun onBindViewHolder(holder: BaseViewHolder<NewsFeedItem>, position: Int) {
       holder.bind(getItem(position))
    }

    inner class NewsFeedViewHolder(private val binding: ItemNewsFeedBinding) :
        BaseViewHolder<NewsFeedItem>(binding.root) {
        override fun bind(modelItem: NewsFeedItem) {
            with(binding) {
                newsFeed = modelItem
                val adapter = BannerPagerAdapter(binding.root.context)
                newsFeedViewPager.adapter = adapter
                modelItem.imagesItem?.let {
                    adapter.updateData(it as MutableList<ImageItem>)
                }
                tabLayoutIndicator.setupWithViewPager(newsFeedViewPager)
                executePendingBindings()
                root.setOnClickListener {
                    callback?.invoke(modelItem)
                }
            }
        }
    }

    inner class NewsFeedType1ViewHolder(private val binding: ItemNewsFeedType1Binding) :
        BaseViewHolder<NewsFeedItem>(binding.root) {
        override fun bind(modelItem: NewsFeedItem) {
            with(binding) {
                newsFeed = modelItem
                executePendingBindings()
                root.setOnClickListener {
                    callback?.invoke(modelItem)
                }
            }
        }
    }

    inner class NewsFeedType2ViewHolder(private val binding: ItemNewsFeedType2Binding) :
        BaseViewHolder<NewsFeedItem>(binding.root) {
        override fun bind(modelItem: NewsFeedItem) {
            with(binding) {
                newsFeed = modelItem
                executePendingBindings()
                root.setOnClickListener {
                    callback?.invoke(modelItem)
                }
            }
        }
    }
}
