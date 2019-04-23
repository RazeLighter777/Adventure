package implementations.items;

import core.Game;
import lib.templates.StaticItem;
import org.json.JSONObject;

public class Ball extends StaticItem {

    public static final long serialVersionUID = 1;

    public Ball(JSONObject jo) {

    }
    @Override
    public String getFullName() {
        return "Ball";
    }

    @Override
    public String getBaseName() {
        return "Ball";
    }

    @Override
    public String getGeneralDescription() {
        return "A red ball.";
    }

    @Override
    public String getDetailedDescription() {
        return Game.getInstance().getStringManager().loadString("core.json", "BallDD");
    }
}
