package environment;

import java.io.Serializable;
import java.util.Optional;

import lib.internalApi.instance.IInstance;
import lib.internalApi.environment.Point;
import org.json.JSONObject;

public abstract class Room implements IInstance, Serializable {
    

    public static final long serialVersionUID = 1;

    protected IWorld world;

    protected RoomSection mainSection;
    
    protected RoomSection[] roomSections;

    //This marks the default room environment that the sections can access.
    protected IEnvironment roomEnvironment;

    protected boolean solid;

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
        return roomEnvironment;
    }

    public boolean isClear() {
        return solid;
    }

    public IWorld getWorld() {
        return world;
    }

    public Optional<JSONObject> queryProperty() {
        return Optional.empty();
    }

}