package fr.arikkusan.arksnvanillaplus.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.BlockDataMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemsManager {

    public static ItemStack InventoryKeeper;
    public static ItemStack Teleporter;
    public static ItemStack PortableEnderChest;
    public static ItemStack PortableCraftingTable;

    private static ArrayList<String> lore;

    public static void init() {

        initInventoryKeeper();
        initTeleporter();

    }

    private static void initTeleporter() {
        lore = new ArrayList<>();

        Teleporter = new ItemStack(Material.ENDER_PEARL);
        ItemMeta meta = Teleporter.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Teleporter");

        lore.add(ChatColor.GRAY + "Item Allowing you to TP");
        lore.add(ChatColor.GRAY + "from where you are to a");
        lore.add(ChatColor.GRAY + "specific place which was");
        lore.add(ChatColor.GRAY + "set before.");

        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        Teleporter.setItemMeta(meta);

        ItemStack stack = ItemsManager.Teleporter;
        ShapedRecipe craft = new ShapedRecipe(NamespacedKey.minecraft("teleporter"), stack);

        craft.shape("AAA", "ABA", "AAA");
        craft.setIngredient('A', Material.ENDER_PEARL);
        craft.setIngredient('B', Material.SADDLE);

        Bukkit.getServer().addRecipe(craft);
    }

    private static void initInventoryKeeper() {
        lore = new ArrayList<>();

        InventoryKeeper = new ItemStack(Material.CHEST);
        ItemMeta metadata = InventoryKeeper.getItemMeta();
        assert metadata != null;
        metadata.setDisplayName(
                ChatColor.AQUA + "" + ChatColor.BOLD + "InventoryKeeper"
        );

        lore.add(ChatColor.GRAY + "Item Allowing you to keep");
        lore.add(ChatColor.GRAY + "you're stuff when diying.");
        lore.add("");
        lore.add(ChatColor.GRAY + "Consumed on Death.");

        metadata.setLore(lore);


        metadata.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        metadata.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        InventoryKeeper.setItemMeta(metadata);

        ItemStack stack = ItemsManager.InventoryKeeper;
        ShapedRecipe craft = new ShapedRecipe(NamespacedKey.minecraft("inventorykeeper"), stack);

        craft.shape("AAA", "ABA", "AAA");
        craft.setIngredient('A', Material.IRON_BLOCK);
        craft.setIngredient('B', Material.CHEST);

        Bukkit.getServer().addRecipe(craft);

    }

    public static ItemStack getInventoryKeeper() {
        InventoryKeeper.setAmount(1);
        return InventoryKeeper;
    }

    public static ItemStack getInventoryKeeper(int amount) {
        InventoryKeeper.setAmount(amount);
        return InventoryKeeper;
    }





}



