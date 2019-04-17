package implementations.environment.Rooms;


import org.json.JSONObject;

import environment.IWorld;
import environment.Room;
import lib.internalApi.Point;

import java.util.Optional;

public class RandomNaturalTerrain extends Room {

    private static transient TerrainDescriptor[] terrains = new TerrainDescriptor[] {
            new TerrainDescriptor(TerrainType.DESERT, "A desert", "Barren strech of sand as far as the eye can see"),
            new TerrainDescriptor(TerrainType.HILL, "Some grassy hills", "Rolling green spring hills"),
            new TerrainDescriptor(TerrainType.SNOW, "A snowy plain", "Barren stretch of fluffy snow"),
            new TerrainDescriptor(TerrainType.SWAMP, "A marshy swamp", "A humid, moist, muddy, swamp"),
            new TerrainDescriptor(TerrainType.PLAIN, "A grassy plain", "Tall grasses across a flat fertile plain")
    };

    private enum TerrainType {
        DESERT, SNOW, SWAMP, PLAIN, HILL
    }

    private TerrainType terrainType;

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
        terrainType = terrains[p.hashCode() % terrains.length].type;
    }

    public void update() {
        //do nothing
    }

    public String getFullName() {
        return "Natural" + terrainType.toString();
    }

    public String getBaseName() {
        return "Natural";
    }

    public Optional<String> getFactoryAssetId() {
        return Optional.empty();
    }

    public String getGeneralDescription() {
        for (TerrainDescriptor td : terrains) {
            if (td.equals(terrainType)) {
                return td.genD;
            }
        }
        return "";
    }

    public String getDetailedDescription() {
        for (TerrainDescriptor td : terrains) {
            if (td.equals(terrainType)) {
                return td.detD;
            }
        }
        return "";
    }

    public void receiveDeletionRequest () {
        return;
    }
}