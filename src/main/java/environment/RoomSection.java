package environment;

import java.io.Serializable;
import java.util.ArrayList;

import lib.internalApi.Position;
import lib.internalApi.SectionLink;
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


    /**
     * 
     * @return A brief description of the feature
     */
    public abstract String getGeneralDescription();


    /**
     * 
     * @return A detailed description of the feature
     */
    public abstract String getDetailedDescription();


    /**
     *  
     * @return An arraylist of links to other positions.
     */
    public abstract ArrayList<SectionLink> getLinks();
    
}