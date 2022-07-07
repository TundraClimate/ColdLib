package io.github.tundraclimate.coldlib.util

import io.github.tundraclimate.coldlib.ColdLib
import org.bukkit.scheduler.BukkitRunnable

fun runTask(async: Boolean = false, task: Runnable) {
    val scheduler = ColdLib.plugin.server.scheduler
    if (!async) scheduler.runTask(ColdLib.plugin, task)
    else scheduler.runTaskAsynchronously(ColdLib.plugin, task)
}

fun <T> T.runTask(async: Boolean = false, task: Runnable) {
    val scheduler = ColdLib.plugin.server.scheduler
    if (!async) scheduler.runTask(ColdLib.plugin, task)
    else scheduler.runTaskAsynchronously(ColdLib.plugin, task)
}

fun <T> T.runTask(async: Boolean = false, task: T.() -> Unit) {
    val runnable = object : BukkitRunnable() {
        override fun run() {
            task()
        }
    }
    if (!async) runnable.runTask(ColdLib.plugin)
    else runnable.runTaskAsynchronously(ColdLib.plugin)
}

fun runTaskLater(delay: Long, async: Boolean = false, task: Runnable) {
    val scheduler = ColdLib.plugin.server.scheduler
    if (!async) scheduler.runTaskLater(ColdLib.plugin, task, delay)
    else scheduler.runTaskLaterAsynchronously(ColdLib.plugin, task, delay)
}

fun <T> T.runTaskLater(delay: Long, async: Boolean = false, task: Runnable) {
    val scheduler = ColdLib.plugin.server.scheduler
    if (!async) scheduler.runTaskLater(ColdLib.plugin, task, delay)
    else scheduler.runTaskLaterAsynchronously(ColdLib.plugin, task, delay)
}

fun <T> T.runTaskLater(delay: Long, async: Boolean = false, task: T.() -> Unit) {
    val runnable = object : BukkitRunnable() {
        override fun run() {
            task()
        }
    }
    if (!async) runnable.runTaskLater(ColdLib.plugin, delay)
    else runnable.runTaskLaterAsynchronously(ColdLib.plugin, delay)
}