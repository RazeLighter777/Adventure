package lib.templates;

import lib.internalApi.instance.IInventory;
import models.Item;

import java.util.ArrayList;

public class Inventory implements IInventory {

    public static final long serialVersionUID = 1;

    private int capacity;

    private double weightCapacity;

    private double volumeCapacity;


    /**
     *
     * @param c The capacity of the inventory
     * @param w The maximum allowed weight of the inventory
     * @param v The maximum allowed volume in the inventory
     * @param initialItems The initial items in the inventory
     */
    public Inventory(int c, double w, double v, ArrayList<Item> initialItems) {
        capacity = c;
        weightCapacity = w;
        volumeCapacity = v;
        items = initialItems;
    }
    private ArrayList<Item> items;

    protected double getVolume() {
        double volumeTotal = 0.0;
        for (Item i : items) {
            volumeTotal += i.getVolume();
        }
        return volumeTotal;
    }

    protected  double getWeight() {
        double weightTotal = 0.0;
        for (Item i : items) {
            weightTotal += i.getWeight();
        }
        return weightTotal;
    }


    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean addItem(Item i) {
        if ((items.size() + 1 <= getMaxCapacity()) && ((getWeight() + i.getWeight()) <= getWeightMaximum()) && ((getVolume() + i.getVolume()) <= getVolumeMaximum())) {
            //Attempt to stack the item.
            for (Item p : items) {
                if (p.stackable() && (p.getFullName().equals(i.getFullName()))) {
                    p.pushStack(1);
                    return true;
                }
            }
            //Otherwise just add it.
            items.add(i);
            return true;
        }
        return false;
    }

    public boolean removeItem(Item i) {
        for (Item p : items) {
            if (p.getFullName().equals(i.getFullName())) {
                items.remove(p);
                return true;
            }
        }
        return false;
    }

    public boolean removeItem(Item i, int quantity) {
        for (Item p : items) {
            if (p.stackable() && (p.getFullName().equals(i.getFullName()))) {
                if (p.stackQuantity() >= quantity) {
                    p.popStack(quantity);
                    if (p.stackQuantity() == 0) {
                        items.remove(p);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public double getWeightMaximum() {
        return weightCapacity;
    }

    public double getVolumeMaximum() {
        return volumeCapacity;
    }

    public double getMaxCapacity() {
        return capacity;
    }




}