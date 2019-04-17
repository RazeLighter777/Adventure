package implementations.environment.Rooms;


import environment.IEnvironment;
import lib.internalApi.Environment.Environment;
import org.json.JSONObject;

import environment.IWorld;
import environment.Room;
import lib.internalApi.Environment.Point;

import java.io.Serializable;
import java.util.Optional;

public class RandomNaturalTerrain extends Room {

    public static final long serialVersionUID = 1;

    private static TerrainDescriptor[] terrains = new TerrainDescriptor[] {
            new TerrainDescriptor(TerrainType.DESERT, new Environment(0.2, 90, 1, 0), "A desert", "Barren strech of sand as far as the eye can see"),
            new TerrainDescriptor(TerrainType.HILL, new Environment(0.1, 65, 0.8, 0.2), "Some grassy hills", "Rolling green spring hills"),
            new TerrainDescriptor(TerrainType.SNOW, new Environment(0.7, 15, 1, 0), "A snowy plain", "Barren stretch of fluffy snow"),
            new TerrainDescriptor(TerrainType.SWAMP, new Environment(0.6, 75, 0.5, 0.8), "A marshy swamp", "A humid, moist, muddy, swamp"),
            new TerrainDescriptor(TerrainType.PLAIN, new Environment(0.1, 60, 1, 0.2), "A grassy plain", "Tallish grasses across a flat fertile plain")
    };

    private enum TerrainType {
        DESERT, SNOW, SWAMP, PLAIN, HILL
    }


    //This is transient because it is from the world seed.
    private TerrainDescriptor terrainDescriptor;

    private static class TerrainDescriptor implements Serializable {

        public static final long serialVersionUID = 1;

        public IEnvironment env;

        public TerrainType type;

        public String genD;

        public String detD;

        TerrainDescriptor(TerrainType type_, IEnvironment e, String gD, String dD) {
            type = type_;
            genD = gD;
            detD = dD;
            env = e;
        }
    }

    public RandomNaturalTerrain(IWorld w, Point p, JSONObject json) {
        super(w, p);
        //Change this to the random world generator
        if (json.get("type") != JSONObject.NULL) {

            for (TerrainDescriptor td : terrains) {
                if (td.type.equals(TerrainType.valueOf(json.getString("type")))) {
                    terrainDescriptor = td;
                }
            }
        } else {
            //Get the TD from the world seed.
            terrainDescriptor= terrains[(w.getWorldSeed().hashCode() + p.hashCode()) % terrains.length];
        }
        roomEnvironment = terrainDescriptor.env;
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