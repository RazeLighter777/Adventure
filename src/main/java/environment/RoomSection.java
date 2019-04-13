package environment;

import java.io.Serializable;

import lib.internalApi.Position;
public abstract class RoomSection implements Serializable {

    public static final long serialVersionUID = 1;

    public Room parentRoom;

    public RoomSection(Room r) {
        parentRoom = r;
    }
    public Position getPosition() {
        return new Position(parentRoom, this);
    }

    public abstract IEnvironment getEnvironment();

    public abstract String getGeneralDescription();

    public abstract String getDetailedDescription();
    
}