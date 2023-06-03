package fr.arikkusan.arksnvanillaplus;

import fr.arikkusan.arksnvanillaplus.Enchants.Unbreakable;
import fr.arikkusan.arksnvanillaplus.Items.ItemsManager;
import fr.arikkusan.arksnvanillaplus.Listeners.OnDeathListener;
import fr.arikkusan.arksnvanillaplus.Listeners.OnInterractionListeners;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public final class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        ItemsManager.init();

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "ArksnUtils plugin launched with success");



        addSaddleCraft();

        registerEnchantements();
        registerListeners();
        registerCommands();


    }

    private void registerEnchantements() {
        registerEnchant(new Unbreakable(NamespacedKey.minecraft("unbreakable")));
    }

    private void registerEnchant(Enchantment enchantment) throws RuntimeException {
        boolean registered = true;
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);

        }  catch (NoSuchFieldException | IllegalAccessException e) {
            registered = false;
            e.printStackTrace();
        }

        if (registered)
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "" + enchantment.getKey() + " enchant registered with success");
        else
            getServer().getConsoleSender().sendMessage(ChatColor.RED + "" + enchantment.getKey() + " enchant registration error");


    }

    private void registerCommands() {
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new OnDeathListener(), this);
        getServer().getPluginManager().registerEvents(new OnInterractionListeners(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "ArksnUtils plugin stopped with success");

    }



    private static void addSaddleCraft() {

        ItemStack stack = new ItemStack(Material.SADDLE);
        ShapedRecipe craft = new ShapedRecipe(NamespacedKey.minecraft("customsaddle"), stack);

        craft.shape("AAA", "A A", "B B");
        craft.setIngredient('A', Material.LEATHER);
        craft.setIngredient('B', Material.STRING);


        Bukkit.getServer().addRecipe(craft);


    }

    public static Main getInstance() {
        return instance;
    }
}
