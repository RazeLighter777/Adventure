package implementations;

import environment.IWorld;
import environment.Room;
import implementations.environment.Rooms.RandomNaturalTerrain;
import lib.internalApi.Environment.Point;
import lib.lambdas.IWorldGenerationLambda;
import org.json.JSONObject;

public class RandomNaturalTerrainWorldGenerator implements IWorldGenerationLambda {

    /**
     * Just generate a random room at that point.
     * @param w The world
     * @param p The point
     * @return The room
     */
    public Room generateRoom(IWorld w, Point p) {
        return new RandomNaturalTerrain(w, p, new JSONObject());
    }

}
