package models;

import java.io.Serializable;
import java.util.Optional;

import environment.IWorld;
import lib.internalApi.Environment.Position;
import lib.internalApi.Instance.PhysicalInstance;

public abstract class Actor extends PhysicalInstance implements Serializable {

    public static final long serialVersionUID = 1;

    protected IWorld world;

    public Actor(IWorld worldContext) {
        world = worldContext;
    }

    /**
     * 
     * @return The position of the actor.
     */
    public abstract Position getPosition();

    //API Functions

    public abstract void reposition(Position p);

    public void reposition(Position p, Actor cause) {
        reposition(p);
    }

    public abstract boolean topple(Actor cause);

    public abstract boolean sendDeletionRequest(Item i);

    public boolean sendDeletionRequest(Item i, Actor cause) {
        return sendDeletionRequest(i);
    }

    /**
     * Picks up an item from an item container or item actor wrapper.
     * @return An item if the thing was picked up correctly
     */
    public abstract Optional<Item> pickUp();
}