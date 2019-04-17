package lib.internalApi.Environment;

import java.util.ArrayList;
import java.util.Arrays;

import environment.IEnvironment;
import environment.RoomSection;
import environment.Room;

public class MainSection extends RoomSection {

    public static final long serialVersionUID = 1;


    private SectionLink[] sectionLinks;
    public MainSection(Room mainRoom, SectionLink[] links) {
        super(mainRoom);
        sectionLinks = links;
    }

    public IEnvironment getEnvironment() {
        return parentRoom.getEnvironment();
    }

    public String getGeneralDescription() {
        return parentRoom.getGeneralDescription();
    }

    public String getDetailedDescription() {
        return parentRoom.getDetailedDescription();
    }

    public SectionLink[] getLinks() {
        return sectionLinks;
    }

    public boolean isSolid() {
        return parentRoom.isSolid();
    }




}
