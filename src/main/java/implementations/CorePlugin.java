package implementations;

import api.*;
import environment.IWorldGenerationAlgorithm;
import implementations.actors.Rock;
import implementations.items.Ball;
import lib.factories.ActorFactory;
import lib.factories.ItemFactory;
import models.Item;

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
    }

    public IWorldGenerationAlgorithm[] getGenerationAlgorithms() {
        return null;
    }

    public IRoomFactory[] loadRoomFactories() {
        return null;
    }

    public IItemFactory[] loadItemFactories() {
        return new IItemFactory[] {
                new ItemFactory<>(Ball.class, "Ball")
        };
    }

    public IActorFactory[] loadActorFactories() {
        return new IActorFactory[] {
                new ActorFactory<>(Rock.class, "Rock")
        };
    }

    //Returns nothing because the core plugins classes are already loaded
    public Class<?>[] getClasses() {
        return new Class<?>[0];
    }

}