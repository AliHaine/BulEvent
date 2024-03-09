package com.alihaine.bulevent.game

import org.bukkit.Location
import org.bukkit.inventory.ItemStack

abstract class GameConfig : Game {
    val isRunning = false
    val isEnable = false
    val singleMode = true
    val rewards = listOf<ItemStack>()
    val rewardsSingleMode = true
    val scoreboardEnable = false
    val locations = listOf<Location>()

    fun scoreboardBuilder() {

    }

    fun schedulerBuilder() {

    }
}