package api;

import lib.lambdas.IWorldGenerationLambda;

public interface IPlugin {

    String getPluginName();

    String getPluginDescription();

    int getPluginVersion();
    
    void initializePlugin();

    IWorldGenerationLambda[] getGenerationAlgorithms();

    IRoomFactory[] loadRoomFactories();

    IItemFactory[] loadItemFactories();

    IActorFactory[] loadActorFactories();
}