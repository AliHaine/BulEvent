package com.alihaine.bulevent

import com.alihaine.bulevent.commands.BE
import com.alihaine.bulevent.data.FileManager
import com.alihaine.bulevent.data.FileType
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class BulEvent : JavaPlugin() {
    companion object {
        lateinit var dataFolderVal: File
            private set;

        lateinit var bulEvent: BulEvent
            private set
    }

    override fun onEnable() {
        this.getCommand("be").executor = BE()
        dataFolderVal = this.dataFolder
        bulEvent = this;
        FileManager.setStringToFile(FileType.TOTEM, "totem_size", "10")
        println("oui" + FileManager.getStringFromFile(FileType.TOTEM, "totem_size"))

    }

    override fun onDisable() {
        FileManager.saveAllFile()
    }
}