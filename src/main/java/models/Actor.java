package models;

import java.io.Serializable;
import java.util.Optional;

import environment.IWorld;
import models.Item;
import lib.internalApi.*;

public abstract class Actor extends PhysicalInstance implements Serializable  {

    public static final long serialVersionUID = 1;

    protected IWorld world;

    public Actor(IWorld worldContext) {
        world = worldContext;
    }

    public abstract Position getPosition();

    public abstract Item[] getInventory();
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

    public abstract Optional<Item> pickUp();
}