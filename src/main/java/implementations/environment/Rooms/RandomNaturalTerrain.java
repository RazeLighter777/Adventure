package implementations.environment.Rooms;


import org.json.JSONObject;

import environment.IWorld;
import environment.Room;
import lib.internalApi.Point;

//Will not be abstract
public abstract class RandomNaturalTerrain extends Room {

    private static TerrainDescriptor[] terrains;

    public static void initialize() {
        terrains = new TerrainDescriptor[] {
             new TerrainDescriptor(TerrainType.DESERT, "A desert", "Barren strech of sand as far as the eye can see"),
             new TerrainDescriptor(TerrainType.HILL, "Some grassy hills", "Rolling green spring hills"),
        };
    }

    private enum TerrainType {
        DESERT, SNOW, SWAMP, PLAIN, HILL
    }
    private static class TerrainDescriptor {

        public TerrainType type;

        public String genD;

        public String detD;

        TerrainDescriptor(TerrainType type_, String gD, String dD) {
            type = type_;
            genD = gD;
            detD = dD;
        }
    }
    public static final long serialVersionUID = 1;

    public RandomNaturalTerrain(IWorld w, Point p, JSONObject json) {
        super(w, p);
    }
}