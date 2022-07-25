package io.github.tundraclimate.coldlib

import io.github.tundraclimate.coldlib.server.ListenEvent
import org.bukkit.plugin.java.JavaPlugin

class ColdLib : JavaPlugin() {
    companion object {
        lateinit var plugin: JavaPlugin
        fun info(log: String) = plugin.logger.info(log)
        fun warn(log: String) = plugin.logger.warning(log)
    }

    private val version = "0.0.4"
    override fun onEnable() {
        server.pluginManager.registerEvents(ListenEvent, this)
        logger.info(
            """
                
            -============================================-
            
                ColdLib Online..! version: $version 
                                        by Tundra_Climate
            -============================================-
            """.trimIndent()
        )
    }
}