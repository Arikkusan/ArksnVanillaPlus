package fr.arikkusan.arksnvanillaplus.Listeners;

import fr.arikkusan.arksnvanillaplus.Items.InventoryKeeperObj;
import fr.arikkusan.arksnvanillaplus.Items.ItemsManager;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class OnDeathListener implements Listener {

    @EventHandler
    public void deathListener(PlayerDeathEvent e) {
        Player p = e.getEntity().getPlayer();

        assert p != null;
        Inventory inv = p.getInventory();

        if (!inv.containsAtLeast(ItemsManager.InventoryKeeper, 1)) return;
        inv.removeItem(ItemsManager.getInventoryKeeper());
        e.setKeepInventory(true);
        e.setKeepLevel(true);
        e.getDrops().clear();
        e.setDroppedExp(0);

        Location l = p.getBedSpawnLocation();
        if (l == null) l = Objects.requireNonNull(Bukkit.getServer().getWorld("world")).getSpawnLocation();

        p.teleport(l);

        e.setDeathMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "(!) La mort elle même n'a su réellement tuer " + p.getDisplayName());
        for (Player player : Bukkit.getServer().getOnlinePlayers())
            player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1f, 1f);


    }

}
