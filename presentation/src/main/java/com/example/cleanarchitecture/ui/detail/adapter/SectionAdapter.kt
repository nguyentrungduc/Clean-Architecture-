package com.example.cleanarchitecture.ui.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.BaseViewHolder
import com.example.cleanarchitecture.databinding.*
import com.example.cleanarchitecture.model.SectionItem
import com.google.android.material.tabs.TabLayoutMediator

class SectionAdapter: ListAdapter<SectionItem, BaseViewHolder<SectionItem>>(SectionItemDiffCallback()) {

    companion object {
        const val SECTION_TYPE_1 = 1
        const val SECTION_TYPE_2 = 2
        const val SECTION_TYPE_3 = 3
    }

    override fun getItemViewType(position: Int): Int {
        return currentList[position].sectionType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        SECTION_TYPE_1 -> SectionType1ViewHolder(
            ItemSectionType1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        SECTION_TYPE_2 -> SectionType2ViewHolder(
            ItemSectionType2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        SECTION_TYPE_3 -> SectionType3ViewHolder(
            ItemSectionType3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        else ->
            throw NullPointerException("View holder for type $viewType not found")
    }

    override fun onBindViewHolder(holder: BaseViewHolder<SectionItem>, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SectionType1ViewHolder(private val binding: ItemSectionType1Binding) :
        BaseViewHolder<SectionItem>(binding.root) {
        override fun bind(modelItem: SectionItem) {
            with(binding) {
                section = modelItem
                val listWebView = modelItem.contentItem?.markupItem?.filter {
                    !it.href.isNullOrBlank()
                }
                if (listWebView.isNullOrEmpty()) {
                    webViewPager.visibility = View.GONE
                    return
                }
                val webViewAdapter = WebviewPagerAdapter()
                webViewPager.apply {
                    adapter = webViewAdapter
                }
                webViewAdapter.updateData(listWebView)
                TabLayoutMediator(tabLayout, webViewPager) { _, _ ->
                }.attach()
            }
        }
    }

    inner class SectionType2ViewHolder(private val binding: ItemSectionType2Binding) :
        BaseViewHolder<SectionItem>(binding.root) {
        override fun bind(modelItem: SectionItem) {
            with(binding) {
                section = modelItem
                executePendingBindings()
                controlView.setOnClickListener {
                    if (videoView.isPlaying) {
                        controlView.setImageDrawable(ContextCompat.getDrawable(controlView.context, R.drawable.ic_baseline_slow_motion_video_24))
                        videoView.pause()
                    }
                    else {
                        controlView.setImageDrawable(ContextCompat.getDrawable(controlView.context, R.drawable.ic_baseline_pause_24))
                        videoView.start()
                    }
                }
            }
        }
    }

    inner class SectionType3ViewHolder(private val binding: ItemSectionType3Binding) :
        BaseViewHolder<SectionItem>(binding.root) {
        override fun bind(modelItem: SectionItem) {
            with(binding) {
                section = modelItem
                executePendingBindings()
            }
        }
    }
}
