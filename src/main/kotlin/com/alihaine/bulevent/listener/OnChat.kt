package com.alihaine.bulevent.listener

import com.alihaine.bulevent.BulEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

//todo if disable
class OnChat : Listener {
    private val guiManager = BulEvent.guiManager

    @EventHandler
    fun onPlayerChat(event: AsyncPlayerChatEvent) {
        if (!event.player.isOp)
            return
        if (!guiManager.isPlayerInWaitForPlayer(event.player.name))
            return
        event.isCancelled = true;
    }
}