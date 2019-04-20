package core;

import static org.junit.Assert.assertTrue;

import implementations.RandomNaturalTerrainWorldGenerator;
import lib.internalApi.Environment.Point;
import org.json.JSONObject;
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
        World w = new World(g, new RandomNaturalTerrainWorldGenerator());
        w.getRoomAt(new Point(3, 2));
        //g.beginGame(new JSONObject());
        assertTrue( true );
    }
}
