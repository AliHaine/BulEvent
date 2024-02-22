package com.alihaine.bulevent.commands


import com.alihaine.bulevent.data.FileManager
import com.alihaine.bulevent.data.FileType
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class BE : CommandExecutor {
    override fun onCommand(p0: CommandSender?, p1: Command?, p2: String?, p3: Array<out String>?): Boolean {
        return true
    }
}