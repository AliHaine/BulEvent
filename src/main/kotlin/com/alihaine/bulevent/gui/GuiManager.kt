package com.alihaine.bulevent.gui

import com.alihaine.bulevent.data.FileStructure
import com.alihaine.bulevent.data.FileType
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.HumanEntity
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import java.util.*


class GuiManager {

    private val guis: EnumMap<GuiType, Inventory> = EnumMap(GuiType::class.java)

    private fun setupEnumMap() {
        defaultGUI()
    }

    private fun defaultGUI() {
        val inv = Bukkit.createInventory(null, 9, "§eBulEvent")
        inv.setItem(3, ItemStack(Material.PAPER))
        inv.setItem(5, ItemStack(Material.PAPER))
        guis[GuiType.DEFAULT] = inv
    }

    fun openInventory(guiType: GuiType, ent: HumanEntity) {
        ent.openInventory(guis[guiType])
    }
}