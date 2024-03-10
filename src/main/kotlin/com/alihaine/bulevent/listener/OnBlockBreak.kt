package com.alihaine.bulevent.listener

import com.alihaine.bulevent.BulEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class OnBlockBreak : Listener {

    private val totemGame = BulEvent.totemGame

    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        if (!totemGame.isRunning || !totemGame.isBlockOfTotem(event.block))
            return
        event.isCancelled = true;
        totemGame.destroyTotemBlock(event.player, event.block.location)
    }
}