package implementations.environment;

import java.util.ArrayList;
import java.util.Optional;

import org.json.JSONObject;

import api.IActorFactory;
import api.IItemFactory;
import api.IPlugin;
import core.Game;
import environment.*;
import models.*;
import lib.internalApi.*;
import lib.lambdas.IWorldGenerationLambda;


public abstract class World implements IWorld {

    public static final long serialVersionUID = 1;

    private transient Game game;

    private ArrayList<Actor> actors;

    private ArrayList<ArrayList<Room>> rooms;

    private transient ArrayList<IAction> actionQueue;

    private transient ArrayList<Actor> deletionRequests;

    private transient IWorldGenerationLambda worldGenerator;

    public World(Game g, IWorldGenerationLambda gen) {
        worldGenerator = gen;
        setGame(g);
        generateRooms();
    }

    public void setGame(Game g) {
        game = g;
    }

    protected void generateRooms() {
        worldGenerator.generateWorld(this, rooms);
    }

    public Actor[] getActorsInRoom(Room m) {
        ArrayList<Actor> r = new ArrayList<Actor>();
        for (Actor a : actors) {
            if (a.getPosition().getRoom() == m) {
                r.add(a);
            }
        }
        return r.toArray(new Actor[r.size()]);
    }    

    public Actor[] getActorsAtPosition(Position p) {
        ArrayList<Actor> r = new ArrayList<>();
        for (Actor a : actors) {
            if (a.getPosition() == p) {
                r.add(a);
            }
        }
        return r.toArray(new Actor[r.size()]);
    }    

    public Room[] getRoomsInDirection(Position p, Position q) {
        ArrayList<Room> r = new ArrayList<>();
        int x0 = p.getRoom().getPoint().getX();
        int y0 = p.getRoom().getPoint().getY();
        int x1 = p.getRoom().getPoint().getX();
        int y1 = p.getRoom().getPoint().getY();
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1; 
        int sy = y0 < y1 ? 1 : -1; 
        int err = dx-dy;
        int e2;
        while (true) 
        {
            r.add(rooms.get(x0).get(y0));
            if (x0 == x1 && y0 == y1) 
                break;
            e2 = 2 * err;
            if (e2 > -dy) 
            {
                err = err - dy;
                x0 = x0 + sx;
            }
            if (e2 < dx) 
            {
                err = err + dx;
                y0 = y0 + sy;
            }
        }                                
        return r.toArray(new Room[r.size()]);
    }

    public void submitAction(IAction a) {
        actionQueue.add(a);
    }

    public void createActor(Actor a) {
        for (Actor actor : actors) {
            if (actor == a) {
                return;
            }
        }
        actors.add(a);
    }

    public Optional<Actor> createActor(String factoryClassName, Position p, JSONObject j) {
        for (IPlugin pl : game.plugins) {
            if (factoryClassName.split(".")[0].equals(pl.getPluginName())) {
                for (IActorFactory af : pl.loadActorFactories()) {
                    return Optional.of(af.createActor(p, j));
                }
            }
        }
        return Optional.empty();
    }

    public Optional<Item> createItem(String factoryClassName, JSONObject j) {
        for (IPlugin pl : game.plugins) {
            if (factoryClassName.split(".")[0].equals(pl.getPluginName())) {
                for (IItemFactory af : pl.loadItemFactories()) {
                    return Optional.of(af.createItem(j));
                }
            }
        }
        return Optional.empty();
    }

    public void update() {
        //update the actors
        for (Actor i : actors) {
            i.update();
        }
        //apply lambdas
        for (IAction action : actionQueue) {
            action.apply();
        }
        actionQueue.clear();
        //update the rooms
        for (ArrayList<Room> r : rooms) {
            for (Room c : r) {
                c.update();
            }
        }
        //process deletion requests.
        for (Actor a : deletionRequests) {
            actors.remove(a);
        }
    }

    public void sendDeletionRequest(Actor a) {
        deletionRequests.add(a);
    }



}