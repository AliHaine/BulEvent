package com.alihaine.bulevent.commands


import com.alihaine.bulevent.BulEvent
import com.alihaine.bulevent.data.FileType
import com.alihaine.bulevent.gui.GuiGameType
import com.alihaine.bulevent.gui.inventory.GuiType
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player


class BE : CommandExecutor {
    private val guiManager = BulEvent.guiManager

    override fun onCommand(sender: CommandSender?, p1: Command?, p2: String?, p3: Array<out String>?): Boolean {
        val player = if (sender is Player) sender else null
        BulEvent.fileManager.getStringListFromFile(FileType.MESSAGE, "")
        if (player == null)
            return true
        //guiManager.openInventory(GuiGameType.DEFAULT, GuiType.DEFAULT, player)
        BulEvent.totemGame.gameStart()
        BulEvent.fileManager.getStringListFromFile(FileType.MESSAGE, "")
        return true
    }
}