package com.alihaine.bulevent

import com.alihaine.bulevent.commands.BE
import com.alihaine.bulevent.data.FileManager
import com.alihaine.bulevent.data.FileType
import com.alihaine.bulevent.game.games.Totem
import com.alihaine.bulevent.gui.GuiManager
import com.alihaine.bulevent.listener.OnBlockBreak
import com.alihaine.bulevent.listener.OnInventory
import org.bukkit.plugin.java.JavaPlugin

class BulEvent : JavaPlugin() {
    companion object {
        lateinit var bulEvent: BulEvent
            private set

        lateinit var fileManager: FileManager
            private set

        lateinit var guiManager: GuiManager
            private set

        lateinit var totemGame: Totem
            private set

    }

    override fun onEnable() {
        bulEvent = this
        fileManager = FileManager()
        guiManager = GuiManager()

        totemGame = Totem()

        this.getCommand("be").executor = BE()
        server.pluginManager.registerEvents(OnInventory(), this)
        server.pluginManager.registerEvents(OnBlockBreak(), this)

        fileManager.setValueToFile(FileType.TOTEM, "allowed_items", "")
        println("oui" + fileManager.getStringFromFile(FileType.TOTEM, "totem_size"))

    }

    override fun onDisable() {
    }
}