package io.github.teamfurrydevs.macas.definitions

enum class AttributeMergeRule(val value: Int) {
    Unknown(0),
    Combine(1),
    Overwrite(2),
    Unique(3);
}