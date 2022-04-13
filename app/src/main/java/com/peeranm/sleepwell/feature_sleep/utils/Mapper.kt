package com.peeranm.sleepwell.feature_sleep.utils

interface Mapper<Entity, Model> {
    fun toEntity(model: Model, shouldIgnoreId: Boolean = false): Entity
    fun fromEntity(entity: Entity): Model
}