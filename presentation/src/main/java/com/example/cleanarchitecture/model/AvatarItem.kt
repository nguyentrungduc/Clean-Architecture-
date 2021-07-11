package com.example.cleanarchitecture.model

import com.example.cleanarchitecture.base.ItemMapper
import com.example.cleanarchitecture.base.ModelItem
import com.example.cleanarchitecture.domain.model.Avatar
import javax.inject.Inject

data class AvatarItem(val href: String?, val mainColor: String?, val width: Int?, val height: Int?) : ModelItem()

class AvatarItemMapper @Inject constructor() : ItemMapper<Avatar, AvatarItem> {
    override fun mapToPresentation(model: Avatar) = AvatarItem(
        model.href, model.mainColor, model.width, model.height
    )

    override fun mapToDomain(modelItem: AvatarItem) = Avatar(
        modelItem.href, modelItem.mainColor, modelItem.width, modelItem.height
    )
}