package com.example.cleanarchitecture.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.cleanarchitecture.base.BasePagerAdapter
import com.example.cleanarchitecture.databinding.ItemPageWebviewBinding
import com.example.cleanarchitecture.model.MarkupItem

class WebviewPagerAdapter: BasePagerAdapter<MarkupItem, ItemPageWebviewBinding>() {

    override fun createBinding(parent: ViewGroup): ItemPageWebviewBinding {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ItemPageWebviewBinding.inflate(layoutInflater, parent, false)
    }

    override fun bind(binding: ItemPageWebviewBinding, item: MarkupItem, position: Int) {
        binding.markup = item
    }

    fun updateData(listMarkup: List<MarkupItem>) {
        items.clear()
        items.addAll(listMarkup)
        notifyDataSetChanged()
    }
}

