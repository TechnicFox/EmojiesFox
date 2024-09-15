package org.technicfox.emojiesFox.menusystem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public abstract class Menu implements InventoryHolder {


    protected PlayerMenuUtility playerMenuUtility;
    protected Inventory inventory;


    public Menu(PlayerMenuUtility playerMenuUtility) {
        this.playerMenuUtility = playerMenuUtility;
    }

    public abstract String getMenuName();

    public abstract int getSlots();

    public abstract void handleMenu(InventoryClickEvent e);

    public abstract void setMenuItems();

    public void open() {
        inventory = Bukkit.createInventory(this, getSlots(), getMenuName());

        this.setMenuItems();

        playerMenuUtility.getOwner().openInventory(inventory);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }


    public ItemStack getEmoji(Integer id, String name) {
        if (id == null || id == 0 || name == null) {
            return null;
        }
        final ItemStack emoji = new ItemStack(Material.WOODEN_AXE);
        ItemMeta ItemMeta = emoji.getItemMeta();
        ItemMeta.setItemName(name);
        ItemMeta.setHideTooltip(true);
        ItemMeta.setCustomModelData(id);

        emoji.setItemMeta(ItemMeta);
        return emoji;
    }

}
