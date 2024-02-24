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

const val TITLE = "§eBulEvent"

class GuiManager {

    private val guis: EnumMap<GuiType, Inventory> = EnumMap(GuiType::class.java)

    init {
        defaultGui()
        totemGui()
    }

    private fun defaultGui() {
        val inv = Bukkit.createInventory(null, 9, TITLE)
        inv.setItem(3, createItemStack(Material.PAPER, "§rTotem", listOf("a")))
        inv.setItem(5, createItemStack(Material.PAPER, "§rKoth", listOf()))
        guis[GuiType.DEFAULT] = inv
    }

    private fun totemGui() {
        val inv = Bukkit.createInventory(null, 27, TITLE)
        inv.setItem(0, ItemStack(Material.QUARTZ))
        inv.setItem(5, ItemStack(Material.PAPER))
        guis[GuiType.TOTEM] = inv
    }

    private fun createItemStack(material: Material, title: String, lore: List<String>): ItemStack {
        val itemStack = ItemStack(material)
        val itemMeta = itemStack.itemMeta

        itemMeta.displayName = title
        itemMeta.lore = lore
        itemStack.itemMeta = itemMeta
        return itemStack
    }

    fun openInventory(guiType: GuiType, ent: HumanEntity) {
        ent.openInventory(guis[guiType])
    }

    fun isCustomInventory(title: String): Boolean {
        for (inv in guis)
            if (inv.value.title == title)
                return true;
        return false
    }
}