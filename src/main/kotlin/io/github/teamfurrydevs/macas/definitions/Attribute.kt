package io.github.teamfurrydevs.macas.definitions

import java.util.UUID

data class Attribute(
    val uuid: UUID,
    val name: String, // Can only contain A-Z, a-z, 0-9, -, or _
                      // This will be used when addressing an attribute in a command
                      // If conflicted with another attribute with another uuid,
                      // append "-x" where x counts from 1 and continue if there's any further conflict
    val displayName: String,
    val desc: String,
    val icon: String,
    val type: AttributeType,
    val obtainRules: Set<Pair<AttributeSourceType, String>>, // Can only contain SourceType higher than 100
                                                              // String is used to specify which id, tag,
                                                              // or attribute uuid depending on the SourceType
                                                              // If there's no FromAPI, there will be no API exposed
                                                              // to allow the external mod to give this attribute
                                                              // directly and the String field will be ignored
    val metadata: Map<UUID, String>, // Freeform data. Defining a convention is the best practice.
    val maxLevel: Int, // 0 for inf
    val mergeRule: AttributeMergeRule,
    val maxChoice: Int
)
