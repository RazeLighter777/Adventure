package environment;

import java.io.Serializable;
import java.util.Optional;

import lib.internalApi.environment.Point;
import lib.internalApi.environment.Position;
import lib.internalApi.events.IAction;
import org.json.JSONObject;

import models.*;

public interface IWorld extends Serializable {


    /**
     * Adds a room at a position if it is not already taken
     * @param r The room
     * @param p The point.
     * @return whether it was successful.
     */
    boolean addRoomAt(Room r, Point p);

    /**
     *
     * @param a Submit an action lambda to the world
     */
    void submitAction(IAction a);

    /**
     *
     * @return get the seed that was used to generate this world
     */
    String getWorldSeed();

    /**
     *
     * @param m Gets the actors at a particular room in the world
     * @return an array containing said actors
     */
    Actor[] getActorsInRoom(Room m);

    /**
     *
     * @param p Gets the actors at a particular position in the world
     * @return an array containing said actors
     */
    Actor[] getActorsAtPosition(Position p);

    /**
     *
     * @param p Position 1
     * @param q Position 2
     * @return All rooms between position one and position 2.
     */
    Room[] getRoomsInBetween(Position p, Position q);

    /**
     * Fetches the room at a particular point. If the room does not exist, it will be generated.
     * @param point The point of the room
     * @return The room that was at the point or was just generated at that point
     */
    Room getRoomAt(Point point);

    /**
     * Deletes an entity at the next update.
     * @param a The entity that was requested to be deleted
     */
    void sendDeletionRequest(Actor a);

    /**
     *
     * @param a Creates an actor at a given location on the map
     */
    void addActor(Actor a);

    /**
     * Creates an actor with a plugin
     * @param factoryClassName The name of the actor as in the factory.actor format.
     * @param p The position to create the actor at
     * @param j A JSON String containing any parameters for the actor
     * @return An optional actor if it was successfully created
     */
    Optional<Actor> addActor(String factoryClassName, Position p, JSONObject j);

    /**
     * Creates an item with a plugin
     * @param factoryClassName The name of the item as in the factory.item format.
     * @param j A JSON String containing any parameters for the item.
     * @return returns an item if is was successfully created.
     */
    Optional<Item> createItem(String factoryClassName, JSONObject j);

    /**
     * Updates the map for one tick
     */
    void update();

    /**
     *
     * @return A JSON String containing the world's properties.
     */
    JSONObject queryWorldProperty();


}