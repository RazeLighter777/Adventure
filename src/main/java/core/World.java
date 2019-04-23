package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import lib.internalApi.Environment.Point;
import lib.internalApi.Environment.Position;
import lib.internalApi.Events.IAction;
import org.json.JSONObject;

import api.IActorFactory;
import api.IItemFactory;
import api.IPlugin;
import environment.*;
import models.*;
import environment.IWorldGenerationAlgorithm;
import java.util.Hashtable;

public  class World implements IWorld {

    public static final long serialVersionUID = 1;

    private transient Game game;

    private String worldSeed;

    private ArrayList<Actor> actors;

    private Hashtable<Point, Room> rooms;

    private transient ArrayList<IAction> actionQueue;

    private transient ArrayList<Actor> deletionRequests;

    private transient IWorldGenerationAlgorithm worldGenerator;

    public JSONObject queryWorldProperty() {
        return new JSONObject();
    }

    public World(Game g, IWorldGenerationAlgorithm gen, String worldSeed) {
        setWorldSeed(worldSeed);
        worldGenerator = gen;
        setGame(g);
        rooms = new Hashtable<>();
        actors = new ArrayList<>();
        actionQueue = new ArrayList<>();
        deletionRequests = new ArrayList<>();
    }

    /**
     * We need this to initialize the transients to prevent null pointer exceptions.
     * @param stream The normal serialization stream
     * @throws IOException Probably if the stream is corrupted or missing some how
     * @throws ClassNotFoundException I dunno. Probably if some plugin classes didn't load properly
     */
    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        actors = new ArrayList<>();
        actionQueue = new ArrayList<>();
        deletionRequests = new ArrayList<>();
    }

    public void setWorldSeed(String seed) {
        worldSeed = seed;
    }

    @Override
    public String getWorldSeed() {
        return worldSeed;
    }

    public void setGame(Game g) {
        game = g;
    }

    @Override
    public boolean addRoomAt(Room r, Point p) {
        if (!rooms.containsKey(p)) {
            rooms.put(p, r);
            return true;
        }
        return false;
    }
    @Override
    public Room getRoomAt(Point point) {
        for (Point p : rooms.keySet()) {
            if (p.equals(point)) {
                return rooms.get(p);
            }
        }
        Room r =  worldGenerator.generateAtPoint(this, point);
        rooms.put(point, r);
        return r;
    }

    @Override
    public Actor[] getActorsInRoom(Room m) {
        ArrayList<Actor> r = new ArrayList<>();
        for (Actor a : actors) {
            if (a.getPosition().getRoom() == m) {
                r.add(a);
            }
        }
        return r.toArray(new Actor[r.size()]);
    }    

    @Override
    public Actor[] getActorsAtPosition(Position p) {
        ArrayList<Actor> r = new ArrayList<>();
        for (Actor a : actors) {
            if (a.getPosition() == p) {
                r.add(a);
            }
        }
        return r.toArray(new Actor[r.size()]);
    }    

    @Override
    public Room[] getRoomsInBetween(Position p, Position q) {
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
            r.add(getRoomAt(new Point(x0, y0)));
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

    @Override
    public void submitAction(IAction a) {
        actionQueue.add(a);
    }

    @Override
    public void addActor(Actor a) {
        for (Actor actor : actors) {
            if (actor == a) {
                return;
            }
        }
        actors.add(a);
    }

    @Override
    public Optional<Actor> addActor(String factoryClassName, Position p, JSONObject j) {
        for (IPlugin pl : game.plugins) {
            if (factoryClassName.split(".")[0].equals(pl.getPluginName())) {
                for (IActorFactory af : pl.loadActorFactories()) {
                    if (af.getBaseName().equals(factoryClassName.split(".")[1])) {
                        return Optional.of(af.createActor(p, j));
                    }
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Item> createItem(String factoryClassName, JSONObject j) {
        for (IPlugin pl : game.plugins) {
            if (factoryClassName.split(".")[0].equals(pl.getPluginName())) {
                for (IItemFactory af : pl.loadItemFactories()) {
                    if (af.getBaseName().equals(factoryClassName.split(".")[1])) {
                        return Optional.of(af.createItem(j));
                    }
                }
            }
        }
        return Optional.empty();
    }

    @Override
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
        for (Room r : rooms.values()) {
            r.update();
        }
        //process deletion requests.
        for (Actor a : deletionRequests) {
            actors.remove(a);
        }
    }

    @Override
    public void sendDeletionRequest(Actor a) {
        deletionRequests.add(a);
    }



}