package implementations;

import core.Game;
import core.World;
import implementations.actors.Rock;
import lib.internalApi.Environment.Point;
import org.junit.Test;

public class RockTest {

    @Test
    public void test() {
        World w = new World(new Game(), new RandomNaturalTerrainWorldGenerator(), "test");
        w.addActor(new Rock(w, w.getRoomAt(new Point(0,0)).getMainSection().getPosition()));
        System.out.println(w.getActorsInRoom(w.getRoomAt(new Point(0,0)))[0].getDetailedDescription());
        w.update();
    }
}
