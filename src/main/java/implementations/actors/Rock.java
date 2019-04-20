package implementations.actors;

import environment.IWorld;
import lib.internalApi.Environment.Position;
import lib.templates.StaticActor;

public class Rock extends StaticActor {

    public static final long serialVersionUID = 1;

    public Rock(IWorld w, Position p) {
        super(w, p);
    }
    @Override
    public String getFullName() {
        return "Rock";
    }

    @Override
    public String getBaseName() {
        return "Rock";
    }

    @Override
    public String getGeneralDescription() {
        return "A rock";
    }

    @Override
    public String getDetailedDescription() {
        return "A rocky rock";
    }
}
