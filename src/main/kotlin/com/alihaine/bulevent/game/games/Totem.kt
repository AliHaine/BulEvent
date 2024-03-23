package com.alihaine.bulevent.game.games

import com.alihaine.bulevent.BulEvent
import com.alihaine.bulevent.data.FileType
import com.alihaine.bulevent.game.GameConfig
\\
import com.alihaine.bulevent.utils.PlaceHolderObj
import com.alihaine.bulevent.utils.Message
import org.bukkit.Bukkit.getServer
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Totem : GameConfig() {
    private val fileManager = BulEvent.fileManager
    private val totemSize = fileManager.getStringFromFile(FileType.TOTEM, "totem_size")?.toInt() ?: 5
    private val totemBlock = Material.QUARTZ_BLOCK
    private val allowedItems = listOf<ItemStack>()

    //private val location = this.locations[Random.nextInt(locations.size)]
    private val location = Location(getServer().getWorld("world"), 0.0, 72.0, 0.0);

    override fun gameLoop() {
        TODO("Not yet implemented")
    }

    override fun gameStart() {
        Message.PERM.sendMessage(null,null)
        this.isRunning = true
        //msg start
        buildTotem()
    }

    override fun gameStop() {
        TODO("Not yet implemented")
    }

    private fun buildTotem() {
        for (i in 0..<totemSize)
            Location(location.world, location.x, location.y + i, location.z).block.type = totemBlock
    }

    fun destroyTotemBlock(player: Player, location: Location) {
        location.block.type = Material.AIR
        Message.PLAYER_DESTROY_BLOCK.sendMessage(player, PlaceHolderObj(listOf(ComponentEnum.PLAYER), listOf(player.name)))
    }

    fun isBlockOfTotem(block: Block): Boolean {
        if (block.type != totemBlock)
            return false
        if (block.location.world != location.world || block.location.x != location.x || block.location.z != location.z)
            return false
        if (block.location.y !in location.y..(location.y + (totemSize - 1)))
            return false
        return true
    }
}