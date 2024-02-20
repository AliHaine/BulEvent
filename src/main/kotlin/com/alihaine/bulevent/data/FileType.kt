package com.alihaine.bulevent.data

enum class FileType {
    CONFIG,
    MESSAGE,
    KOTH,
    TOTEM;

    companion object {
        fun getFileName(fileType: FileType): String {
            return fileType.name.lowercase() + ".yml";
        }
    }
}