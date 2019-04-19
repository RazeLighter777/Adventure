package lib.internalApi.Environment;

import core.Game;
import environment.Room;

public class DirectionalLink extends SectionLink {

    public static final long serialVersionUID = 1;

    public enum Direction {
        NORTH, SOUTH, EAST, WEST, NORTHWEST, NORTHEAST, SOUTHEAST, SOUTHWEST;

        public static Point getDirectionVector(Direction d) {
            switch (d) {
                case NORTH:
                    return new Point(0, -1);
                case SOUTH:
                    return new Point(0, 1);
                case EAST:
                    return new Point(-1, 0);
                case WEST:
                    return new Point(1, 0);
                case NORTHEAST:
                    return new Point(-1, -1);
                case NORTHWEST:
                    return new Point(1, -1);
                case SOUTHEAST:
                    return new Point(-1 , 1);
                case SOUTHWEST:
                    return new Point(1, 1);
            }
            return new Point(0,0);
        }
    }

    /**
     * Returns an array of links to every direction on the compass. Useful for open-air sections.
     * @param pRoom The room where the links are being set.
     * @return The array of links
     */
    public static SectionLink[] getCompassSectionLinks(Room pRoom) {
        return new SectionLink[] {
                new DirectionalLink(pRoom, Direction.NORTH),
                new DirectionalLink(pRoom, Direction.SOUTH),
                new DirectionalLink(pRoom, Direction.EAST),
                new DirectionalLink(pRoom, Direction.WEST),
                new DirectionalLink(pRoom, Direction.NORTHWEST),
                new DirectionalLink(pRoom, Direction.NORTHWEST),
                new DirectionalLink(pRoom, Direction.SOUTHWEST),
                new DirectionalLink(pRoom, Direction.SOUTHEAST)
        };
    }

    Room targetRoom;
    Direction linkDirection;

    public DirectionalLink(Room parentRoom, Direction lDirection) {
        super(parentRoom);
        linkDirection = lDirection;
        Point directionVector = Direction.getDirectionVector(lDirection);
        targetRoom = parentRoom.getWorld().getRoomAt(parentRoom.getPoint().add(directionVector));
    }

    @Override
    public String getDirectionDescription() {
        return linkDirection.toString();
    }

    public String getGeneralDescription() {
        return targetRoom.getGeneralDescription();
    }

    public String getDetailedDescription() {
        return targetRoom.getDetailedDescription();
    }

    public Position followLink() {
        return targetRoom.getMainSection().getPosition();
    }

    public boolean isClear() {
        return targetRoom.isClear();
    }

    public double getTravelCost() {
        return targetRoom.getEnvironment().getCover();
    }
}
