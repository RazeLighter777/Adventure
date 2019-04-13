package environment;

import java.io.Serializable;
import lib.internalApi.*;
import models.*;

public interface IWorld extends Serializable {
    
    public void submitAction(IAction a);

    public Actor[] getActorsInRoom(Room m);

    public Actor[] getActorsAtPosition(Position p);

    public Room[] getRoomsInDirection(Actor caller, Position p);

    public void sendDeletionRequest(Actor a);

    public void createActor(Actor a);


}