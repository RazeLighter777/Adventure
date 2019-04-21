package implementations.actors;

import core.Game;
import environment.IWorld;
import lib.internalApi.Environment.Position;
import lib.templates.StaticActor;
import org.json.JSONObject;

public class Rock extends StaticActor {

    public static final long serialVersionUID = 1;

    public Rock(Position p, JSONObject jo) {
        super(Game.getInstance().getWorldInterface(), p);
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
        return Game.getInstance().getStringManager().loadString("core.json", "RockDescription");
    }
}
