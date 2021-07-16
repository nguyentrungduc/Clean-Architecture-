package com.example.cleanarchitecture.data.base

import com.example.cleanarchitecture.domain.model.Model
import io.realm.RealmObject

interface RealmEntityMapper<M : Model, ME : RealmObject> {
    fun mapToDomain(entity: ME): M

    fun mapToEntity(model: M): ME
}

interface EntityMapper<M : Model, ME : ModelEntity> {
    fun mapToDomain(entity: ME): M

    fun mapToEntity(model: M): ME
}