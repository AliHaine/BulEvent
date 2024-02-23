package com.alihaine.bulevent.gui

import org.bukkit.Bukkit
import org.bukkit.entity.HumanEntity
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.meta.ItemMeta
import java.util.*


class GuiManager {

    private var inv: Inventory? = null

    fun ExampleGui() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 9, "Example")

        // Put the items into the inventory
        initializeItems()
    }

    // You can open the inventory with this
    fun openInventory(ent: HumanEntity) {
        ent.openInventory(inv)
    }
}