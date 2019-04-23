package implementations.environment.Rooms;


import core.Game;
import lib.internalApi.Resources.StringManager;
import environment.IEnvironment;
import lib.internalApi.Environment.DirectionalLink;
import lib.internalApi.Environment.Environment;
import lib.internalApi.Environment.MainSection;
import org.json.JSONException;
import org.json.JSONObject;

import environment.IWorld;
import environment.Room;
import lib.internalApi.Environment.Point;

import java.io.Serializable;
import java.util.Optional;

public class RandomNaturalTerrain extends Room {

    public static final long serialVersionUID = 1;

    private static final StringManager sm = Game.getInstance().getStringManager();

    private static TerrainDescriptor[] terrains = new TerrainDescriptor[] {
            new TerrainDescriptor(TerrainType.DESERT, new Environment(0.2, 90, 1, 0), sm.loadString("core.json","DesertGD"), sm.loadString("core.json", "DesertDD")),
            new TerrainDescriptor(TerrainType.HILL, new Environment(0.1, 65, 0.8, 0.2), sm.loadString("core.json", "HillGD"), sm.loadString("core.json", "HillDD")),
            new TerrainDescriptor(TerrainType.SNOW, new Environment(0.7, 15, 1, 0), sm.loadString("core.json", "SnowGD"), sm.loadString("core.json", "SnowDD")),
            new TerrainDescriptor(TerrainType.SWAMP, new Environment(0.6, 75, 0.5, 0.8), sm.loadString("core.json", "SwampGD"), sm.loadString("core.json", "SwampDD")),
            new TerrainDescriptor(TerrainType.PLAIN, new Environment(0.1, 60, 1, 0.2), sm.loadString("core.json", "PlainGD"), sm.loadString("core.json", "PlainDD"))
    };

    private enum TerrainType {
        DESERT, SNOW, SWAMP, PLAIN, HILL
    }


    //This is transient because it is from the world seed.
    private TerrainDescriptor terrainDescriptor;

    private static class TerrainDescriptor implements Serializable {

        private static final long serialVersionUID = 1;

        private IEnvironment env;

        private TerrainType type;

        private String genD;

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
        if (json.isEmpty()) {
            terrainDescriptor= terrains[Math.abs(w.getWorldSeed().hashCode() + p.hashCode()) % terrains.length];
            roomEnvironment = terrainDescriptor.env;
            mainSection = new MainSection(this, DirectionalLink.getCompassSectionLinks(this));
            return;
        }
        try {
            for (TerrainDescriptor td : terrains) {
                if (td.type.equals(TerrainType.valueOf(json.getString("type")))) {
                    terrainDescriptor = td;
                }
            }
        } catch (JSONException e) {
            //Get the TD from the world seed.
        }
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
    }


}