package implementations;

import api.*;
import lib.lambdas.IWorldGenerationLambda;

public class CorePlugin  implements IPlugin {

    public String getPluginName() {
        return "core";
    }

    public String getPluginDescription() {
        return "The core game files and classes.";
    }

    public int getPluginVersion() {
        return 1;
    }

    public void initializePlugin() {
        return;
    }

    public IWorldGenerationLambda[] getGenerationAlgorithms() {
        return null;
    }

    public IRoomFactory[] loadRoomFactories() {
        return null;
    }

    public IItemFactory[] loadItemFactories() {
        return null;
    }

    public IActorFactory[] loadActorFactories() {
        return null;
    }

}