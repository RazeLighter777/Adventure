package lib.internalApi;


import environment.*;
import lib.internalApi.Point;

public class Position {

    private Room room;
    
    private RoomSection section;

    public Position(Room initialRoom) {
        room = initialRoom;
        section = room.getMainSection();
    }

    public Position(Room initialRoom, RoomSection initialSection) {
        this(initialRoom);
        section = initialSection;
    }

    public Room getRoom() {
        return room;
    }

    public RoomSection getSection() {
        return section;
    }

    public final Point getPoint() {
        return room.getPoint();
    }

    public IEnvironment getEnvironment() {
        return room.getEnvironment();
    }
}