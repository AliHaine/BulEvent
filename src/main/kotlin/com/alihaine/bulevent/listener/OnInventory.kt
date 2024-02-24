package com.alihaine.bulevent.listener

import com.alihaine.bulevent.BulEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryDragEvent

class OnInventory : Listener {

    private val guiManager = BulEvent.guiManager

    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        if (!guiManager.isCustomInventory(event.inventory.title))
            return
        event.isCancelled = true
    }

    @EventHandler
    fun onInventoryDrag(event: InventoryDragEvent) {
        if (!guiManager.isCustomInventory(event.inventory.title))
            return
        event.isCancelled = true
    }

}