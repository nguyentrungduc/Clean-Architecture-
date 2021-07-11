package com.example.cleanarchitecture.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.cleanarchitecture.model.ImageItem

@BindingAdapter("imageUrl")
fun loadImage(view: AppCompatImageView, urls: List<ImageItem>?) {
    if (urls?.isNotEmpty() == true)
    Glide.with(view.context).load(urls[0].href).into(view)
}

@BindingAdapter(value = ["imageUrlWithIndex", "index"])
fun loadImageIndex(view: AppCompatImageView, urls: List<ImageItem>?, index: Int) {
    if (!urls.isNullOrEmpty() && urls.size > index) {
        Glide.with(view.context).load(urls[index].href).into(view)
    }
}
