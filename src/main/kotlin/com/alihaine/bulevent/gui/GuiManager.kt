package com.alihaine.bulevent.gui

import com.alihaine.bulevent.gui.inventory.GuiInventories
import com.alihaine.bulevent.gui.inventory.GuiType
import com.alihaine.bulevent.gui.inventory.inventories.Default
import org.bukkit.entity.HumanEntity
import java.util.*

const val TITLE = "§eBulEvent"

class GuiManager {
    private val guis: EnumMap<GuiGameType, GuiInventories> = EnumMap(GuiGameType::class.java)

    init {
        for (guiType in GuiGameType.entries) {
            val factory = when (guiType) {
                GuiGameType.DEFAULT -> Default()
                GuiGameType.TOTEM -> Default()
                GuiGameType.KOTH -> Default()
            }
            guis[guiType] = factory
        }
    }

    fun openInventory(guiType: GuiGameType, guiGameType: GuiType, ent: HumanEntity) {
        ent.openInventory(guis[guiType]?.inventories?.get(guiGameType) ?: return)
    }

    fun isCustomInventory(title: String): Boolean {
        if (TITLE == title)
            return true;
        return false
    }
}