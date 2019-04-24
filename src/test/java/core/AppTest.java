package core;

import static org.junit.Assert.assertTrue;

import implementations.RandomNaturalTerrainWorldGenerator;
import lib.internalApi.environment.Point;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Game g = new Game();
        World w = new World(g, new RandomNaturalTerrainWorldGenerator(), "test");
        w.getRoomAt(new Point(3, 2));
        //g.beginGame(new JSONObject());
        assertTrue( true );
    }
}
