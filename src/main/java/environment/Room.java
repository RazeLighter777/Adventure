package environment;

import java.io.Serializable;

import lib.internalApi.IInstance;
import lib.internalApi.Point;

public abstract class Room implements IInstance, Serializable {
    

    public static final long serialVersionUID = 1;

    protected IWorld world;

    protected RoomSection mainSection;
    
    protected RoomSection[] roomSections;

    private Point point;

    public Room(IWorld w, Point p) {
        point = p; world = w;
    }

    public Point getPoint() {
        return point;
    }

    public RoomSection[] getRoomSections() {
        return roomSections;
    }
    public RoomSection getMainSection() {
        return mainSection;
    }

    public IEnvironment getEnvironment() {
        return mainSection.getEnvironment();
    }



}