package com.alihaine.bulevent.data

import com.alihaine.bulevent.BulEvent
import org.bukkit.configuration.InvalidConfigurationException
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException
import java.util.*


class FileManager {
    private val files: EnumMap<FileType, FileStructure> = setupEnumMap()

    private fun setupEnumMap(): EnumMap<FileType, FileStructure> {
        var newFile: File
        var fileConf: FileConfiguration
        val newMap: EnumMap<FileType, FileStructure> = EnumMap(FileType::class.java)
        for (fileType in FileType.entries) {
            //todo if game is disable return
            val fileName = getFileName(fileType)
            newFile = File(BulEvent.bulEvent.dataFolder, fileName)
            if (!newFile.exists()) {
                newFile.getParentFile().mkdirs()
                BulEvent.bulEvent.saveResource(fileName, false)
            }
            fileConf = YamlConfiguration()
            try {
                fileConf.load(newFile)
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: InvalidConfigurationException) {
                e.printStackTrace()
            }
            newMap[fileType] = FileStructure(newFile, fileConf)
        }
        return newMap
    }

    fun setValueToFile(fileType: FileType, path: String, value: Any) {
        files[fileType]?.fileConfig?.set(path, value)
        saveFile(fileType)
    }

    fun getStringFromFile(fileType: FileType, path: String): String? {
        println(files[fileType]?.fileConfig)
        return files[fileType]?.fileConfig?.getString(path)
    }

    fun getStringListFromFile(fileType: FileType, path: String): MutableList<String>? {
        return files[fileType]?.fileConfig?.getStringList(path)
    }

    fun getBooleanFromFile(fileType: FileType, path: String): Boolean? {
        return files[fileType]?.fileConfig?.getBoolean(path)
    }

    private fun saveFile(fileType: FileType) {
        files[fileType]?.fileConfig?.save(files[fileType]?.file)
    }

    private fun getFileName(fileType: FileType): String {
        return fileType.name.lowercase() + ".yml";
    }
}