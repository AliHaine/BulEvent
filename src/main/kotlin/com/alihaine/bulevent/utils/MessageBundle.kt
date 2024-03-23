package com.alihaine.bulevent.utils

import org.bukkit.entity.Player

class MessageBundle {
    companion object {
        private val messageList: HashMap<String, List<String>> = hashMapOf()

        init {
            //open the file, fill the messageList with the content of message.yml, then close the file

        }
    }
    private var message: List<String> = listOf();

    fun sendMessage(player: Player) {
        if (message.isEmpty())
            return
        for (line in message)
            player.sendMessage(line.replace('&', '§'))
    }

    fun withPlaceHolder(placeHolder: String, value: String): MessageBundle {
        message.indices.forEach { i ->
            if (message[i].contains('%'))
                message[i].replace(placeHolder, value)
        }
        return this
    }

    fun createBuilder(messagePath: String): MessageBundle {
        message = messageList.getOrDefault(messagePath, emptyList())
        return this
    }
}