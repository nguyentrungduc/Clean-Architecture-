package com.example.cleanarchitecture.ui.newsfeed.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ItemPageImageBinding
import com.example.cleanarchitecture.model.ImageItem

class BannerPagerAdapter(private val mContext: Context) : PagerAdapter() {

    private val listItem: MutableList<ImageItem> = arrayListOf()

    private lateinit var itemPageImageBinding: ItemPageImageBinding

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as FrameLayout
    }

    override fun getCount(): Int {
        return listItem.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as FrameLayout)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        itemPageImageBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_page_image, container, false)

        itemPageImageBinding.imageItem = listItem[position]
        container.addView(itemPageImageBinding.root)
        return itemPageImageBinding.root
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    fun updateData(list: MutableList<ImageItem>) {
        listItem.clear()
        listItem.addAll(list)
        notifyDataSetChanged()
    }

}