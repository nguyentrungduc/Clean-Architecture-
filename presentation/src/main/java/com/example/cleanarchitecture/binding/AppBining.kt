package com.example.cleanarchitecture.binding

import android.webkit.WebView
import android.widget.VideoView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.cleanarchitecture.model.ImageItem

@BindingAdapter("imageUrl")
fun loadImage(view: AppCompatImageView, urls: List<ImageItem>?) {
    if (urls?.isNotEmpty() == true)
        Glide.with(view.context)
            .load(urls[0].href)
            .transform(CenterCrop(), RoundedCorners(12))
            .into(view)
}

@BindingAdapter(value = ["imageUrlWithIndex", "index"])
fun loadImageIndex(view: AppCompatImageView, urls: List<ImageItem>?, index: Int) {
    if (!urls.isNullOrEmpty() && urls.size > index) {
        Glide.with(view.context).load(urls[index].href).transform(CenterCrop(), RoundedCorners(12))
            .into(view)
    }
}

@BindingAdapter("loadUrl")
fun loadImageUrl(view: AppCompatImageView, url: String?) {
    Glide.with(view.context)
        .load(url ?: "https://cdn.24h.com.vn/upload/3-2021/images/2021-07-22/1626797773_362712_1626797891_noticia_normal_recorte1-740-1626913920-838-width740height416.jpg")
        .transform(CenterCrop(), RoundedCorners(12))
        .into(view)
}

@BindingAdapter("loadWebView")
fun loadWebView(webView: WebView, url: String) {
    webView.loadUrl(url)
}

@BindingAdapter("loadUrlVideo")
fun loadUrlVideo(videoView: VideoView, url: String) {
    videoView.setVideoPath(url)
    videoView.start()
}
