package io.github.tundraclimate.coldlib.addon

import com.google.common.collect.Multimap
import io.github.tundraclimate.coldlib.ColdLib
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

class NewItemStack(private val material: Material) {
    var displayName: String? = null
    var lore: List<String>? = null
    var customModelData: Int? = null
    var localizeName: String? = null
    var enchants = mutableMapOf<Enchantment, Int>()
    var isUnbreakable = false
    var itemFlags = arrayOf<ItemFlag>()
    var attributeModifiers: Multimap<Attribute, AttributeModifier>? = null
    var amount = 1
    var type = material
    val item: ItemStack
        get() {
            val itemStack = ItemStack(material)
            val meta = itemStack.itemMeta
            meta?.let { m ->
                m.setDisplayName(displayName)
                m.lore = lore
                m.setCustomModelData(customModelData)
                m.setLocalizedName(localizeName)
                m.isUnbreakable = isUnbreakable
                m.addItemFlags(*itemFlags)
                m.attributeModifiers = attributeModifiers
                itemStack.setItemMeta(m)
            }
            itemStack.addUnsafeEnchantments(enchants)
            itemStack.amount = amount
            itemStack.type = type
            return itemStack
        }

    fun <T, Z : Any> addDataContainer(key: String, type: PersistentDataType<T, Z>, value: Z) {
        val meta = item.itemMeta
        meta?.persistentDataContainer?.set(
            NamespacedKey(ColdLib.plugin, key),
            type,
            value
        )
        item.itemMeta = meta
    }
}