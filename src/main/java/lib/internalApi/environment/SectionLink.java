package lib.internalApi.environment;

import environment.Room;

import java.io.Serializable;

public abstract class SectionLink implements Serializable {

    public static final long serialVersionUID = 1;

    protected Room parentRoom;

    public SectionLink(Room parentRoom) {
        this.parentRoom = parentRoom;
    }
    /**
     * 
     * @return A description string (North, down, up, left, tunnel, etc)
     */
    public abstract String getDirectionDescription();
    /**
     * 
     * @return A brief description of the feature
     */
    public abstract String getGeneralDescription();

    /**
     * 
     * @return A detailed description of the feature.
     */
    public abstract String getDetailedDescription();

    /**
     * 
     * @return The position this links to.
     */
    public abstract Position followLink();

    /**
     * Whether the position this links to can be perceived. 0 is imperceptible, 1 is clear
     * @return whether it can be percieved.
     */
    public abstract double getClarity();
    /**
     * 
     * @return The cost of traveling through the link
     */
    public abstract double getTravelCost();


}