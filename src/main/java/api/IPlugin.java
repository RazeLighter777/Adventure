package api;

import environment.IWorldGenerationAlgorithm;

public interface IPlugin {

    String getPluginName();

    String getPluginDescription();

    int getPluginVersion();
    
    void initializePlugin();

    Class<?>[] getClasses();

    IWorldGenerationAlgorithm[] getGenerationAlgorithms();

    IRoomFactory[] loadRoomFactories();

    IItemFactory[] loadItemFactories();

    IActorFactory[] loadActorFactories();
}