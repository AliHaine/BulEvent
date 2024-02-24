package com.alihaine.bulevent.commands


import com.alihaine.bulevent.BulEvent
import com.alihaine.bulevent.data.FileManager
import com.alihaine.bulevent.data.FileType
import com.alihaine.bulevent.gui.GuiType
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
import org.bukkit.entity.HumanEntity
import org.bukkit.entity.Player


class BE : CommandExecutor {
    private val guiManager = BulEvent.guiManager

    override fun onCommand(sender: CommandSender?, p1: Command?, p2: String?, p3: Array<out String>?): Boolean {
        val player = if (sender is Player) sender else null
        if (player == null)
            return true
        guiManager.openInventory(GuiType.DEFAULT, player)
        return true
    }
}