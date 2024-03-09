package com.alihaine.bulevent.gui.inventory

import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import java.util.*

abstract class GuiInventories {
    val inventories: EnumMap<GuiType, Inventory> = EnumMap(GuiType::class.java)

    protected fun createItemStack(material: Material, title: String, lore: List<String>): ItemStack {
        val itemStack = ItemStack(material)
        val itemMeta = itemStack.itemMeta

        itemMeta.displayName = title
        itemMeta.lore = lore
        itemStack.itemMeta = itemMeta
        return itemStack
    }
}