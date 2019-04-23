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
        System.out.println(plugin.loadActorFactories()[0].createActor(w.getRoomAt(new Point(0,0)).getMainSection().getPosition(), new JSONObject()).getDetailedDescription());
        System.out.println(plugin.loadItemFactories()[0].createItem(new JSONObject()).getDetailedDescription());
        w.update();
    }
}
