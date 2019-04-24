package lib.internalApi.instance;

import java.io.Serializable;
import java.util.ArrayList;

import models.Item;

public interface IInventory extends Serializable {

    /**
     * 
     * @return An arraylist of items eligable to be taken.
     */
    ArrayList<Item> getItems();

    /**
     * Adds an item to the inventory
     * @return Whether the item was removed
     */
    boolean addItem(Item i);

    /**
     * Removes an item from the inventory
     * @param m The item to be removed.
     * @return Whether the removal was accepted.
     */
    boolean removeItem(Item m);

    /**
     * Removes multiple items from the inventory
     * @param m The item to be removed
     * @param quantity The quanity to remove it in
     * @return Whether the item was actually removed.
     */
    boolean removeItem(Item m, int quantity);

    /**
     *
     * @return The maximum volume allowed in the inventory
     */
    double getVolumeMaximum();

    /**
     *
     * @return The maximum weight allowed in the inventory
     */
    double getWeightMaximum();

    /**
     *
     * @return The maximum number of items allowed in the inventory
     */
    double getMaxCapacity();



}