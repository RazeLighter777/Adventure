package implementations;

import core.Game;
import core.World;
import lib.internalApi.Environment.Point;
import org.junit.Test;

public class RandomNaturalTerrainWorldGeneratorTest {

    @Test
    public void test() {
        Game g = new Game();
        World w = new World(g, new RandomNaturalTerrainWorldGenerator());
        w.setWorldSeed("worldSeed");
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                w.getRoomAt(new Point(x, y));
            }
        }
    }
}
