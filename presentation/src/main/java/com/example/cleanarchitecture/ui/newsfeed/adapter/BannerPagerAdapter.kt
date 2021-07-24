package com.example.cleanarchitecture.ui.newsfeed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.cleanarchitecture.base.BasePagerAdapter
import com.example.cleanarchitecture.databinding.ItemPageImageBinding
import com.example.cleanarchitecture.model.ImageItem

class BannerPagerAdapter(
    private val onImageClickListener: OnImageClickListener
) : BasePagerAdapter<ImageItem, ItemPageImageBinding>() {

    override fun createBinding(parent: ViewGroup): ItemPageImageBinding {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ItemPageImageBinding.inflate(layoutInflater, parent, false)
    }

    override fun bind(binding: ItemPageImageBinding, item: ImageItem, position: Int) {
        binding.imageItem = item
        binding.root.setOnClickListener {
            onImageClickListener.onClickImage(item)
        }
    }

    fun updateData(images: List<ImageItem>) {
        items.clear()
        items.addAll(images)
        notifyDataSetChanged()
    }
}

interface OnImageClickListener {
    fun onClickImage(item: ImageItem)
}

