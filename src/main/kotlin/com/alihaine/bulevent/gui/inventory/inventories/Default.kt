package com.alihaine.bulevent.gui.inventory.inventories

import com.alihaine.bulevent.gui.TITLE
import com.alihaine.bulevent.gui.action.Action
import com.alihaine.bulevent.gui.inventory.GuiInventories
import com.alihaine.bulevent.gui.inventory.GuiType
import org.bukkit.Bukkit
import org.bukkit.Material

class Default() : GuiInventories() {
    init {
        defaultGui()
    }

    private fun defaultGui() {
        val inv = Bukkit.createInventory(null, 9, TITLE)
        inv.setItem(3, createItemStack(Material.PAPER, "§e" + Action.OPEN.title, listOf("§eTotem")))
        inv.setItem(5, createItemStack(Material.PAPER, "§e" + Action.OPEN.title, listOf("§eKoth")))
        inventories[GuiType.DEFAULT] = inv
    }
}