package io.github.teamfurrydevs.macas.definitions

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import java.util.*
import kotlin.uuid.Uuid
import kotlin.uuid.toJavaUuid
import kotlin.uuid.toKotlinUuid


data class AttributeData(
    val attributeUuid: UUID,
    var expireTicks: Long,  // -1 = Not temporary

    val metadata: Map<UUID, String>, // Freeform data. Defining a convention is the best practice.

    var level: Int, // 0 for inf
    var choice: Map<UUID, String>
)

internal object AttributeCodec {
    private val SOURCE_TYPE_ENTRIES = AttributeSourceType.entries
    private val SOURCE_TYPE_VALUES = SOURCE_TYPE_ENTRIES.map { it.value }

    private val SOURCE_TYPE_CODEC: Codec<AttributeSourceType> = Codec.INT.xmap(
        { id ->
            val index = SOURCE_TYPE_VALUES.indexOf(id)
            if (index != -1) SOURCE_TYPE_ENTRIES[index] else AttributeSourceType.Unknown
        },
        { it.value }
    )

    private val UUID_CODEC: Codec<UUID> = Codec.INT_STREAM.xmap(
        { stream ->
            val arr = stream.toArray()
            (if (arr.size != 4) {
                Uuid.fromLongs(0L, 0L).toJavaUuid()
            } else {
                val most = (arr[0].toLong() shl 32) or (arr[1].toLong() and 0xFFFFFFFFL)
                val least = (arr[2].toLong() shl 32) or (arr[3].toLong() and 0xFFFFFFFFL)
                Uuid.fromLongs(most, least).toJavaUuid()
            }) as UUID?
        },
        { uuid ->
            uuid.toKotlinUuid().toLongs { most, least ->
                java.util.stream.IntStream.of(
                    (most ushr 32).toInt(),
                    most.toInt(),
                    (least ushr 32).toInt(),
                    least.toInt()
                )
            }
        }
    )

    private val UUID_STRING_MAP_CODEC: Codec<Map<UUID, String>> =
        Codec.unboundedMap(UUID_CODEC, Codec.STRING)

    @JvmField
    internal val CODEC: Codec<AttributeData> =
        RecordCodecBuilder.create { instance ->
            instance.group(
                UUID_CODEC.fieldOf("attribute_uuid")
                    .forGetter(AttributeData::attributeUuid),

                Codec.LONG.fieldOf("expire_ticks")
                    .forGetter(AttributeData::expireTicks),

                UUID_STRING_MAP_CODEC
                    .optionalFieldOf("metadata", emptyMap())
                    .forGetter(AttributeData::metadata),

                Codec.INT.fieldOf("level")
                    .forGetter(AttributeData::level),

                UUID_STRING_MAP_CODEC
                    .optionalFieldOf("choice", emptyMap())
                    .forGetter(AttributeData::choice)
            ).apply(instance, ::AttributeData)
        }
}