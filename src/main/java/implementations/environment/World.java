package implementations.environment;

import java.util.ArrayList;

import environment.*;
import lib.internalApi.Action;
import models.*;
import lib.internalApi.*;


public abstract class World implements IWorld {

    private ArrayList<Actor> actors;

    private ArrayList<ArrayList<Room>> rooms;

    private ArrayList<IAction> actionQueue;

    private ArrayList<Actor> deletionRequests;

    protected abstract void generateRooms();

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

}