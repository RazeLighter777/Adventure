package api;

import core.Game;
import core.World;
import implementations.CorePlugin;
import implementations.RandomNaturalTerrainWorldGenerator;
import implementations.actors.Rock;
import lib.internalApi.Environment.Point;
import org.json.JSONObject;
import org.junit.Test;

public class CorePluginTest {

    @Test
    public void test() {
        World w = new World(new Game(), new RandomNaturalTerrainWorldGenerator(), "test");
        IPlugin plugin = new CorePlugin();
        plugin.loadActorFactories()[0].createActor(w.getRoomAt(new Point(0,0)).getMainSection().getPosition(), new JSONObject());
        w.update();
    }
}
