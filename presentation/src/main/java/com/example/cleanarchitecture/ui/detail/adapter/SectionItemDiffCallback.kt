package com.example.cleanarchitecture.ui.detail.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.cleanarchitecture.model.SectionItem

class SectionItemDiffCallback : DiffUtil.ItemCallback<SectionItem>() {
    override fun areItemsTheSame(oldItem: SectionItem, newItem: SectionItem): Boolean {
        return oldItem.contentItem == newItem.contentItem
    }

    override fun areContentsTheSame(oldItem: SectionItem, newItem: SectionItem): Boolean {
        return oldItem.contentItem == newItem.contentItem
    }
}