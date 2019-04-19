package environment;

import java.io.Serializable;
import java.util.ArrayList;

import lib.internalApi.Environment.Position;
import lib.internalApi.Environment.SectionLink;
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
    public abstract SectionLink[] getLinks();

    /**
     *
     * @return Whether the section can be entered or not.
     */
    public abstract boolean isSolid();

    /**
     * Sets the section links of a section
     * @param links The links to set
     */
    public abstract void setSectionLinks(SectionLink[] links);
    
}