package api;

public interface IPlugin {

    String getPluginName();

    String getPluginDescription();

    int getPluginVersion();
    
    void initializePlugin();

    IRoomFactory[] loadRoomFactories();

    IItemFactory[] loadItemFactories();

    IActorFactory[] loadActorFactories();
}