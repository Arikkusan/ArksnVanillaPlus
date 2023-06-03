package fr.arikkusan.arksnvanillaplus.Listeners;

import fr.arikkusan.arksnvanillaplus.Enchants.Unbreakable;
import fr.arikkusan.arksnvanillaplus.Items.ItemsManager;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class OnInterractionListeners implements Listener {

    @EventHandler
    public void onBlockBroke(BlockBreakEvent e) {
        Player p = e.getPlayer();

        if (p.getInventory().getItemInMainHand().hasItemMeta()) {
            ItemStack stack = p.getInventory().getItemInMainHand();
            //if (stack.containsEnchantment(Enchantment.Unbreakable))

        }


    }
    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent e) {

        switch (e.getBlockPlaced().getType()) {
            case CHEST:
                Player p = e.getPlayer();
                if (p.getInventory().getItemInMainHand().hasItemMeta()) {

                    String itemName = Objects.requireNonNull(p.getInventory().getItemInMainHand().getItemMeta()).getDisplayName();
                    String nameToCheck = Objects.requireNonNull(ItemsManager.InventoryKeeper.getItemMeta()).getDisplayName();

                    if (itemName.equalsIgnoreCase(nameToCheck)) {
                        e.setCancelled(true);
                        break;
                    }
                }
                break;
            default:
                
                break;
        }

    }

}
