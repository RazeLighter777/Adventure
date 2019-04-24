package implementations.actors;

import core.Game;
import lib.internalApi.environment.Position;
import lib.templates.StaticActor;
import org.json.JSONObject;

import java.util.Optional;

public class Rock extends StaticActor {

    @Override
    public double getValue() {
        return 1.0;
    }

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
        return Game.getInstance().getStringManager().loadString("core.json", "RockDD");
    }

    @Override
    public Optional<String> getFactoryAssetId() {
        return Optional.of("core.Rock");
    }
}
