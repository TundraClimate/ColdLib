package io.github.tundraclimate.coldlib.addon

import com.google.common.collect.Multimap
import org.bukkit.Material
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataContainer

class NewItemStack(material: Material) {
    val item = ItemStack(material)
    private val meta = item.itemMeta
    var displayName: String? = meta?.displayName
        set(value) {
            field = value
            item.itemMeta = meta
        }
    var lore: MutableList<String>? = meta?.lore
        set(value) {
            field = value
            item.itemMeta = meta
        }
    var enchants: MutableMap<Enchantment, Int>? = meta?.enchants
        set(value) {
            field = value
            item.itemMeta = meta
        }
    var customModelData: Int? = meta?.customModelData
        set(value) {
            field = value
            item.itemMeta = meta
        }
    var itemFlags: MutableSet<ItemFlag>? = meta?.itemFlags
        set(value) {
            field = value
            item.itemMeta = meta
        }
    var isUnbreakable: Boolean? = meta?.isUnbreakable
        set(value) {
            field = value
            item.itemMeta = meta
        }
    var attributeModifiers: Multimap<Attribute, AttributeModifier>? = meta?.attributeModifiers
        set(value) {
            field = value
            item.itemMeta = meta
        }
    var localizedName: String? = meta?.localizedName
        set(value) {
            field = value
            item.itemMeta = meta
        }
    var dataContainer: PersistentDataContainer? = meta?.persistentDataContainer
        set(value) {
            field = value
            item.itemMeta = meta
        }
    var amount: Int = item.amount
    var type: Material = item.type
}