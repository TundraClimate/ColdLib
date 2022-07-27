package io.github.tundraclimate.coldlib.addon

import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack

class NewInventory(owner: InventoryHolder? = null, row: Int = 3, title: String = "Inventory") {
    val newInv = Bukkit.createInventory(owner, row * 9, title)

    fun fill(itemStack: ItemStack) {
        newInv.forEachIndexed { i, _ -> newInv.setItem(i, itemStack) }
    }

    fun copy(from: Inventory) {
        newInv.contents = from.contents
    }

    fun move(from: Inventory) {
        copy(from)
        from.clear()
    }

    fun cut(from: Inventory = newInv): Array<ItemStack> {
        val tmp = from.contents.clone()
        from.clear()
        return tmp
    }

    fun paste(clip: Array<ItemStack>) {
        newInv.contents = clip
    }
}