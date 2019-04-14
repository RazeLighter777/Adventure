package lib.internalApi;

import java.io.Serializable;
import java.util.ArrayList;

import models.Item;

public interface IInventory extends Serializable {

    /**
     * 
     * @return An arraylist of items eligable to be taken.
     */
    public ArrayList<Item> getItems();

    /**
     * Adds an item to the inventory
     * @return Whether the item was removed
     */
    public boolean addItem();

    /**
     * Removes an item from the inventory
     * @param m The item to be removed.
     * @return Whether the removal was accepted.
     */
    public boolean removeItem(Item m);

    /**
     * Removes multiple items from the inventory
     * @param m The item to be removed
     * @param quantity The quanity to remove it in
     * @return Whether the item was actually removed.
     */
    public boolean removeItem(Item m, int quantity);

}