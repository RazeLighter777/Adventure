package implementations;

import environment.IWorld;
import environment.Room;
import implementations.environment.rooms.RandomNaturalTerrain;
import lib.internalApi.environment.Point;
import environment.IWorldGenerationAlgorithm;
import org.json.JSONObject;

public class RandomNaturalTerrainWorldGenerator implements IWorldGenerationAlgorithm {

    /**
     * Just generate a random room at that point.
     * @param w The world
     * @param p The point
     * @return The room
     */
    public Room generateAtPoint(IWorld w, Point p) {
        return new RandomNaturalTerrain(w, p, new JSONObject());
    }

    public String getName() {
        return "Random natural terrain";
    }

    public String getDescription() {
        return "Generates a highly randomized, featureless wilderness";
    }
}
