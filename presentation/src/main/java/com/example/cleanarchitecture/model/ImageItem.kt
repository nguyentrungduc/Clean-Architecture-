package com.example.cleanarchitecture.model

import android.os.Parcelable
import com.example.cleanarchitecture.base.ItemMapper
import com.example.cleanarchitecture.base.ModelItem
import com.example.cleanarchitecture.domain.model.Image
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject

@Parcelize
data class ImageItem(val href: String?, val mainColor: String?, val width: Int?, val height: Int?) : ModelItem(), Parcelable

class ImageItemMapper @Inject constructor() : ItemMapper<Image, ImageItem> {
    override fun mapToPresentation(model: Image) = ImageItem(
        model.href, model.mainColor, model.width, model.height
    )

    override fun mapToDomain(modelItem: ImageItem) = Image(
        modelItem.href, modelItem.mainColor, modelItem.width, modelItem.height
    )
}