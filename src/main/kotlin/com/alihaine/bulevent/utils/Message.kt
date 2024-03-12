package com.alihaine.bulevent.utils

import com.alihaine.bulevent.BulEvent
import com.alihaine.bulevent.data.FileType
import org.bukkit.Bukkit
import org.bukkit.entity.Player

enum class Message(val path: String) {
    START_SOON("event.start_soon"),
    START("event.start"),
    STOP_SOON("event.stop_soon"),
    STOP("event.stop"),
    WINNER_SOLO("event.winner_solo"),
    WINNER_GROUP("event.winner_group"),
    PERM("admin.perm"),
    RELOAD("admin.reload"),
    EVENT_MANUAL_START("admin.event_manual_start"),
    EVENT_MANUAL_START_ALREADY_ERROR("admin.event_manual_start_already_error"),
    EVENT_MANUAL_START_NOEVENT_ERROR("admin.event_manual_start_noevent_error"),
    EVENT_MANUAL_STOP("admin.event_manual_stop"),
    EVENT_MANUAL_STOP_ERROR("admin.event_manual_stop_error"),
    INGAME_CONFIG_DISABLE("admin.ingame_config_disable");

    companion object {
        private val fileManager = BulEvent.fileManager

        fun sendMessage(player: Player?, msg: Message) {
            //val messageList: List<String> = fileManager.getStringListFromFile(FileType.MESSAGE, msg.path) ?: listOf(fileManager.getStringFromFile(FileType.MESSAGE, msg.path) ?: return)
            var messageList: List<String>? = fileManager.getStringListFromFile(FileType.MESSAGE, msg.path)
            if (messageList == null)
                messageList = listOf(fileManager.getStringFromFile(FileType.MESSAGE, msg.path) ?: return)
            messageSender(player, messageList)
        }

        fun sendMessageComponent(player: Player?, msg: Message, component: ComponentObj) {
            var messageList: List<String>? = fileManager.getStringListFromFile(FileType.MESSAGE, msg.path)
            if (messageList == null)
                messageList = listOf(fileManager.getStringFromFile(FileType.MESSAGE, msg.path) ?: return)
            for (i in messageList.indices)
                messageList[i] = str[i].replace(component.compoEnum.tag, component.value)
            messageSender(player, messageList)
        }

        private fun messageSender(player: Player?, message: List<String>) {
            if (player == null)
                consoleSender(message)
            else
                playerSender(player, message)
        }

        private fun playerSender(player: Player, message: List<String>) {
            for (str in message)
                player.sendMessage(str.replace('&', '§'))
        }

        private fun consoleSender(message: List<String>) {
            for (str in message)
                Bukkit.getConsoleSender().sendMessage(str.replace('&', '§'))

        }
    }
}

enum class ComponentEnum(val tag: String) {
    GAME("%game%"),
    PLAYER("%player%"),
    TIME("%time%");
}

class ComponentObj(val compoEnum: ComponentEnum, val value: String)