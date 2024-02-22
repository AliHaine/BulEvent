package com.alihaine.bulevent.data

import com.alihaine.bulevent.BulEvent
import org.bukkit.configuration.InvalidConfigurationException
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException
import java.util.*


class FileManager(private val file: File, private val fileConfig: FileConfiguration) {
    companion object {
        private val files: EnumMap<FileType, FileManager> = setupEnumMap()

        private fun setupEnumMap(): EnumMap<FileType, FileManager> {
            var newFile: File
            var fileConf: FileConfiguration
            val newMap: EnumMap<FileType, FileManager> = EnumMap(FileType::class.java)
            for (fileType in FileType.entries) {
                //if game is disable return
                val fileName = FileType.getFileName(fileType)
                newFile = File(BulEvent.dataFolderVal, fileName)
                if (!newFile.exists()) {
                    newFile.getParentFile().mkdirs();
                    BulEvent.bulEvent.saveResource(fileName, false)
                }
                fileConf = YamlConfiguration()
                try {
                    fileConf.load(newFile);
                } catch (e: IOException) {
                    e.printStackTrace()
                } catch (e: InvalidConfigurationException) {
                    e.printStackTrace()
                }
                newMap[fileType] = FileManager(newFile, fileConf)
            }
            return newMap
        }

        fun getStringFromFile(fileType: FileType, path: String): String? {
            println(files[fileType]?.fileConfig)
            return files[fileType]?.fileConfig?.getString(path)
        }

        fun setStringToFile(fileType: FileType, path: String, value: String) {
            files[fileType]?.fileConfig?.set(path, value)
        }

        fun getStringListFromFile(fileType: FileType, path: String): MutableList<String>? {
            return files[fileType]?.fileConfig?.getStringList(path)
        }

        fun setStringListToFile(fileType: FileType, path: String, value: MutableList<String>) {
            files[fileType]?.fileConfig?.set(path, value)
        }

        fun saveFile(fileType: FileType) {
            files[fileType]?.fileConfig?.save(files[fileType]?.file)
        }

        fun saveAllFile() {
            for (file in files) {
                file.value.fileConfig.save(file.value.file)
            }
        }
    }
}