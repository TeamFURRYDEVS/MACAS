package io.github.teamfurrydevs.macas.attributedefinitions

import kotlin.uuid.Uuid

data class AttributeInfo(
    val attributeUuid: Uuid,
    val attributeName: String,
    val metadata: Map<String, String>, // Typical convention is having "desc" that contains description
                                       // and "icon" that contains the path to the icon of the attribute
    val attributeType: AttributeType,
    val maxLevel: Int, // 0 for inf
    val hasChoice: Boolean
)
