package com.alihaine.bulevent.gui

import com.alihaine.bulevent.gui.inventory.GuiInventories
import com.alihaine.bulevent.gui.inventory.GuiType
import com.alihaine.bulevent.gui.inventory.inventories.Default
import org.bukkit.entity.HumanEntity
import java.util.*

const val TITLE = "§eBulEvent"

class GuiManager {
    private val guis: EnumMap<GuiGameType, GuiInventories> = EnumMap(GuiGameType::class.java)
    private val waitForEntry: MutableList<String> = mutableListOf()

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

    fun openInventory(guiGameType: GuiGameType, guiType: GuiType, ent: HumanEntity) {
        ent.openInventory(guis[guiGameType]?.inventories?.get(guiType) ?: return)
    }

    fun isCustomInventory(title: String): Boolean {
        if (TITLE == title)
            return true;
        return false
    }

    fun isPlayerInWaitForPlayer(name: String): Boolean {
        return waitForEntry.contains(name)
    }

    fun setPlayerInWaitToEntry(name: String) {
        waitForEntry.add(name)
    }

    fun removePlayerInWaitToEntry(name: String) {
        waitForEntry.remove(name)
    }
}