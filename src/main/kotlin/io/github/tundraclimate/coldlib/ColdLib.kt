package io.github.tundraclimate.coldlib

import org.bukkit.plugin.java.JavaPlugin

class ColdLib : JavaPlugin() {
    private val version = "0.0.1"
    override fun onEnable() {
        logger.info(
            """
                
            -============================================-
            
                ColdLib Online..! version: $version 
                                        by Tundra_Climate
            -============================================-
            """.trimIndent())
    }

    companion object {
        lateinit var plugin: JavaPlugin
    }
}