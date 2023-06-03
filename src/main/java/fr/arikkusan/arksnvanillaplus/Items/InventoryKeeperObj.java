package fr.arikkusan.arksnvanillaplus.Items;

import org.bukkit.inventory.ItemStack;

public class InventoryKeeperObj {

    private ItemStack is;
    private int index;

    public InventoryKeeperObj(ItemStack is, int index) {
        this.is = is;
        this.index = index;
    }

    public ItemStack getIs() {
        return is;
    }

    public void setIs(ItemStack is) {
        this.is = is;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean empty() {
        return is != null;
    }

    public ItemStack getConsumedStack() {
        is.setAmount(is.getAmount() - 1);
        return is;
    }
}
