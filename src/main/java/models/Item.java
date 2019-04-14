package models;

import java.io.Serializable;

import lib.internalApi.PhysicalInstance;
import lib.internalApi.Position;

import java.util.Optional;
import lib.dataStructures.*;

public abstract class Item extends PhysicalInstance implements Serializable {


    public static final long serialVersionUID = 1;

    public abstract boolean stackable();

    /**
     * 
     * @return if the item can be thrown
     */
    public abstract boolean hurlable();

    /**
     * 
     * @return The quantity of items in the stack.
     */
    public abstract int stackQuantity();


    //API 
    
    /**
     * Pops a given amount of items from the stack.
     * @param amount The amount of items popped.
     * @return whether the stack was popped.
     */
    public abstract boolean popStack(int amount);

    /**
     * Pushes items to a stack
     * @param items the quantity of items to be stacked.
     * @return if the items were all stacked.
     */
    public abstract boolean pushStack(int items);


    public abstract Optional<SNutrition> eat(Actor eater);

    /**
     * This tells the item to optinally move to this position if it is hurlable.
     * @param target The position for it to be thrown.
     * @param tSThrow The throw parameters
     * @return whether the item was thrown.
     */
    public abstract boolean hurl(Position target, SThrow tSThrow);

    /**
     * This throws at item at an actor.
     * @param target The actor in question
     * @param tSThrow The throw parameters
     * @return whether the item was thrown
     */
    public abstract boolean hurl(Actor target, SThrow tSThrow);

}