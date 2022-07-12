package io.github.tundraclimate.coldlib.server

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.event.entity.EntityDamageByBlockEvent
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.inventory.*
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerInteractEvent

object ListenEvent : Listener {
    private val interactEventTasks = mutableListOf<(PlayerInteractEvent) -> Unit>()
    private val damageEventTasks = mutableListOf<(EntityDamageEvent) -> Unit>()
    private val damageByEntityEventTasks = mutableListOf<(EntityDamageByEntityEvent) -> Unit>()
    private val damageByBlockEventTasks = mutableListOf<(EntityDamageByBlockEvent) -> Unit>()
    private val deathEntityDeathEvent = mutableListOf<(EntityDeathEvent) -> Unit>()
    private val breakBlockEventTasks = mutableListOf<(BlockBreakEvent) -> Unit>()
    private val placeBlockEventTasks = mutableListOf<(BlockPlaceEvent) -> Unit>()
    private val openInventoryEventTasks = mutableListOf<(InventoryOpenEvent) -> Unit>()
    private val closeInventoryEventTasks = mutableListOf<(InventoryCloseEvent) -> Unit>()
    private val dragInventoryEventTasks = mutableListOf<(InventoryDragEvent) -> Unit>()
    private val clickInventoryEventTasks = mutableListOf<(InventoryClickEvent) -> Unit> ()
    private val moveItemInventoryEventTasks = mutableListOf<(InventoryMoveItemEvent) -> Unit>()
    private val chatOfAsyncEventTasks = mutableListOf<(AsyncPlayerChatEvent) -> Unit>()
    private val spawnCreatureEventTasks = mutableListOf<(CreatureSpawnEvent) -> Unit>()
    fun addInteractTask(task: (PlayerInteractEvent) -> Unit) = interactEventTasks.add(task)
    fun addDamageTask(task: (EntityDamageEvent) -> Unit) = damageEventTasks.add(task)
    fun addDamageByEntityTask(task: (EntityDamageByEntityEvent) -> Unit) = damageByEntityEventTasks.add(task)
    fun addDamageByBlockTask(task: (EntityDamageByBlockEvent) -> Unit) = damageByBlockEventTasks.add(task)
    fun addBreakBlockTask(task: (BlockBreakEvent) -> Unit) = breakBlockEventTasks.add(task)
    fun addPlaceBlockTask(task: (BlockPlaceEvent) -> Unit) = placeBlockEventTasks.add(task)
    fun addOpenInventoryTask(task: (InventoryOpenEvent) -> Unit) = openInventoryEventTasks.add(task)
    fun addCloseInventoryTask(task: (InventoryCloseEvent) -> Unit) = closeInventoryEventTasks.add(task)
    fun addDragInventoryTask(task: (InventoryDragEvent) -> Unit) = dragInventoryEventTasks.add(task)
    fun addClickInventoryTask(task: (InventoryClickEvent) -> Unit) = clickInventoryEventTasks.add(task)
    fun addMoveItemInventoryTask(task: (InventoryMoveItemEvent) -> Unit) = moveItemInventoryEventTasks.add(task)
    fun addChatOfAsyncTask(task: (AsyncPlayerChatEvent) -> Unit) = chatOfAsyncEventTasks.add(task)
    fun addSpawnCreatureTask(task: (CreatureSpawnEvent) -> Unit) = spawnCreatureEventTasks.add(task)

    @EventHandler
    private fun onInteractPlayer(e: PlayerInteractEvent) = interactEventTasks.forEach { it(e) }

    @EventHandler
    private fun onDamageEntity(e: EntityDamageEvent) = damageEventTasks.forEach { it(e) }

    @EventHandler
    private fun onDamageEntityByEntity(e: EntityDamageByEntityEvent) = damageByEntityEventTasks.forEach { it(e) }

    @EventHandler
    private fun onDamageEntityByBlock(e: EntityDamageByBlockEvent) = damageByBlockEventTasks.forEach { it(e) }

    @EventHandler
    private fun onEntityDeath(e: (EntityDeathEvent)) = deathEntityDeathEvent.forEach { it(e) }

    @EventHandler
    private fun onBreakBlock(e: BlockBreakEvent) = breakBlockEventTasks.forEach { it(e) }

    @EventHandler
    private fun onPlaceBlock(e: BlockPlaceEvent) = placeBlockEventTasks.forEach { it(e) }

    @EventHandler
    private fun onOpenInventory(e: InventoryOpenEvent) = openInventoryEventTasks.forEach { it(e) }

    @EventHandler
    private fun onCloseInventory(e: InventoryCloseEvent) = closeInventoryEventTasks.forEach { it(e) }

    @EventHandler
    private fun onDragInventory(e: InventoryDragEvent) = dragInventoryEventTasks.forEach { it(e) }

    @EventHandler
    private fun onClickInventory(e: InventoryClickEvent) = clickInventoryEventTasks.forEach { it(e) }

    @EventHandler
    private fun onMoveItemInventory(e: InventoryMoveItemEvent) = moveItemInventoryEventTasks.forEach { it(e) }

    @EventHandler
    private fun onChatOfAsync(e: AsyncPlayerChatEvent) = chatOfAsyncEventTasks.forEach { it(e) }

    @EventHandler
    private fun onSpawnCreature(e: CreatureSpawnEvent) = spawnCreatureEventTasks.forEach { it(e) }
}