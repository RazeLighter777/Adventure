package environment;

import java.io.Serializable;
import java.util.Optional;

import lib.internalApi.Environment.Position;
import lib.internalApi.Events.IAction;
import org.json.JSONObject;

import models.*;

public interface IWorld extends Serializable {
    
    public void submitAction(IAction a);

    public String getWorldSeed();

    public Actor[] getActorsInRoom(Room m);

    public Actor[] getActorsAtPosition(Position p);

    public Room[] getRoomsInBetween(Position p, Position q);

    public void sendDeletionRequest(Actor a);

    public void createActor(Actor a);

    public Optional<Actor> createActor(String factoryClassName, Position p, JSONObject j);

    public Optional<Item> createItem(String factoryClassName, JSONObject j);

    public void update();

}