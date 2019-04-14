package lib.internalApi;

import java.io.Serializable;

public class SectionLink implements Serializable {

    public static final long serialVersionUID = 1;

    private Position linkPosition;

    private String directionDescription;

    private String generalDescription;

    private String detailedDescription;

    /**
     * Creates a new link
     * @param lPosition The position this link leads to
     * @param dirD A direction descriptor
     * @param gD A general descriptor
     * @param dD A detailed descriptor
     */
    public SectionLink(Position lPosition, String dirD, String gD, String dD) {
        directionDescription = dirD;
        linkPosition = lPosition;
        generalDescription = gD;
        detailedDescription = dD;
    }
    /**
     * 
     * @return A description string (North, down, up, left, tunnel, etc)
     */
    public String getDirectionDescription() {
        return directionDescription;
    }

    /**
     * 
     * @return A brief description of the feature
     */
    public String getGeneralDescription() {
        return generalDescription;
    }

    /**
     * 
     * @return A detailed description of the feature.
     */
    public String getDetailedDescription() {
        return detailedDescription;
    }

    /**
     * 
     * @return The position this links to.
     */
    public Position followLink() {
        return linkPosition;
    }

    /**
     * Whether the position this links to can be percieved.
     * @return whether it can be percieved.
     */
    public boolean isClear() {
        return true;
    }

    /**
     * 
     * @return The cost of traveling through the link
     */
    public double getTravelCost() {
        return 0.0;
    }


}