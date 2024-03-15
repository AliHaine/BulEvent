package com.alihaine.bulevent.utils

import com.alihaine.bulevent.BulEvent
import com.alihaine.bulevent.data.FileType
import org.bukkit.Bukkit
import org.bukkit.entity.Player

enum class Message(val path: String) {
    START_SOON("event_global.start_soon"),
    START("event_global.start"),
    STOP_SOON("event_global.stop_soon"),
    STOP("event_global.stop"),
    WINNER_SOLO("event_global.winner_solo"),
    WINNER_GROUP("event_global.winner_group"),
    PLAYER_DESTROY_BLOCK("event_totem.player_destroy_block"),
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

        fun sendMessage(player: Player?, msg: Message, component: ComponentObj?) {
            //val messageList: List<String> = fileManager.getStringListFromFile(FileType.MESSAGE, msg.path) ?: listOf(fileManager.getStringFromFile(FileType.MESSAGE, msg.path) ?: return)
            var messageList: MutableList<String>? = fileManager.getStringListFromFile(FileType.MESSAGE, msg.path)
            if (messageList.isNullOrEmpty())
                messageList = mutableListOf(fileManager.getStringFromFile(FileType.MESSAGE, msg.path) ?: return)
            if (messageList.isEmpty())
                return
            if (component != null)
                buildMessageComponent(messageList, component)
            messageSender(player, messageList)
        }

        private fun buildMessageComponent(messageList: MutableList<String>, component: ComponentObj) {
            messageList.indices.forEach { i ->
                if (messageList[i].contains('%')) {
                    component.values.indices.forEach { x ->
                        messageList[i] = messageList[i].replace(component.compoEnum[x].tag, component.values[x])
                    }
                }
            }
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

class ComponentObj(val compoEnum: List<ComponentEnum>, val values: List<String>)