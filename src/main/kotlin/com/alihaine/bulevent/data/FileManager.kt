package com.alihaine.bulevent.data

import org.bukkit.configuration.InvalidConfigurationException
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException
import java.util.*


class FileManager(file: File, fileConfig: FileConfiguration) {
    private val files: EnumMap<FileType, FileManager> = EnumMap(FileType::class.java);

    init {
        var newFile: File;
        var fileConf: FileConfiguration;
        for (fileType in FileType.entries) {
            newFile = File(getDataFolder(),  FileType.getFileName(fileType));
            fileConf = YamlConfiguration();
            try {
                fileConf.load(file);
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: InvalidConfigurationException) {
                e.printStackTrace()
            }
            files[FileType.KOTH] = FileManager(newFile, fileConf);
        }
    }
}