package com.alihaine.bulevent.game

import org.bukkit.Location
import org.bukkit.inventory.ItemStack

abstract class GameConfig : Game {
    var isRunning = false
    var isEnable = false
    var singleMode = true
    val rewards = mutableListOf<ItemStack>()
    var rewardsSingleMode = true
    var scoreboardEnable = false
    val locations = mutableListOf<Location>()

    fun scoreboardBuilder() {

    }

    fun schedulerBuilder() {

    }
}