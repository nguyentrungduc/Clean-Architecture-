package com.example.cleanarchitecture.model

import com.example.cleanarchitecture.base.ItemMapper
import com.example.cleanarchitecture.base.ModelItem
import com.example.cleanarchitecture.domain.model.Markup
import javax.inject.Inject

class MarkupItem( val markupType: Int?,
                  val start: Int?,
                  val end: Int?,
                  val href: String?): ModelItem() {
}

class MarkupItemMapper @Inject constructor() : ItemMapper<Markup, MarkupItem> {
    override fun mapToPresentation(model: Markup) = MarkupItem(
        model.markupType, model.start, model.end, model.href
    )

    override fun mapToDomain(modelItem: MarkupItem) = Markup(
        modelItem.markupType, modelItem.start, modelItem.end, modelItem.href
    )
}