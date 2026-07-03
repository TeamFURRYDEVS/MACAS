package io.github.teamfurrydevs.macas.attributedefinitions

import kotlin.uuid.Uuid

data class AttributeData(
    val attributeUuid: Uuid,
    var isTemporary: Boolean,
    var expireCountDownTicks: Long, // Should have a setter and private set

    val sourceType: AttributeSourceType,
    val sourceRefItem: String,

    var level: Int, // 0 for inf
    var hasChoice: Boolean,
    var choice: List<String>
)