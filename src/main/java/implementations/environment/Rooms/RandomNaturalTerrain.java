package implementations.environment.Rooms;


import environment.RoomSection;
import org.json.JSONObject;

import environment.IWorld;
import environment.Room;
import lib.internalApi.Environment.Point;

import java.io.Serializable;
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


    private TerrainDescriptor terrainDescriptor;

    private static class TerrainDescriptor implements Serializable {

        public static final long serialVersionUID = 1;

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
        //Change this to the random world generator
        terrainDescriptor= terrains[(w.getWorldSeed().hashCode() + p.hashCode()) % terrains.length];
    }

    public void update() {
        //do nothing
    }

    public String getFullName() {
        return "Natural" + terrainDescriptor.type.toString();
    }

    public String getBaseName() {
        return "Natural";
    }

    public Optional<String> getFactoryAssetId() {
        return Optional.empty();
    }

    public String getGeneralDescription() {
        return terrainDescriptor.genD;
    }

    public String getDetailedDescription() {
        return terrainDescriptor.detD;
    }

    public void receiveDeletionRequest () {
        return;
    }
}