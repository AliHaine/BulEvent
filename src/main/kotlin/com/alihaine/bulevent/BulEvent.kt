package com.alihaine.bulevent

import com.alihaine.bulevent.commands.BE
import com.alihaine.bulevent.data.FileManager
import com.alihaine.bulevent.data.FileType
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class BulEvent : JavaPlugin() {
    companion object {
        lateinit var bulEvent: BulEvent
            private set

        lateinit var fileManager: FileManager
            private set;

    }

    override fun onEnable() {
        this.getCommand("be").executor = BE()
        bulEvent = this;
        fileManager = FileManager()
        fileManager.setValueToFile(FileType.TOTEM, "allowed_items", "")
        println("oui" + fileManager.getStringFromFile(FileType.TOTEM, "totem_size"))

    }

    override fun onDisable() {
    }
}