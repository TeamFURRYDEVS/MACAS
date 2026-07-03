package io.github.teamfurrydevs.macas.attributedefinitions

enum class AttributeSourceType(val value: Int) {
    FromAttribute(0),
    FromAPI(1),
    FromHoldingItemId(2),
    FromInventoryItemId(3),
    FromEquipmentItemId(4),
    FromInteractionItemId(5),
    FromHoldingItemTag(6),
    FromInventoryItemTag(7),
    FromEquipmentItemTag(8),
    FromInteractionItemTag(9),
    FromCommand(10);
}