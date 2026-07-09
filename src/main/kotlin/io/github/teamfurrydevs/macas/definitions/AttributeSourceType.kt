package io.github.teamfurrydevs.macas.definitions

enum class AttributeSourceType(val value: Int) {
    Unknown(0),
    FromCommand(1),
    FromHoldingItemId(101),
    FromInventoryItemId(102),
    FromEquipmentItemId(103),
    FromInteractionItemId(104),
    FromWhileInteractionItemId(105),
    FromHoldingItemTag(201),
    FromInventoryItemTag(202),
    FromEquipmentItemTag(203),
    FromInteractionItemTag(204),
    FromWhileInteractionItemTag(205),
    FromAPI(301),
    FromAttribute(302);
}