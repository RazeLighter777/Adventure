package lib.internalApi;

public interface IInstance {

    public abstract void update();
    
    public abstract String getFullName();

    public abstract String getBaseName();

    public abstract String getFactoryAssetId();

    public abstract String getGeneralDescription();

    public abstract String getDetailedDescription();

    public abstract void recieveDeletionRequest();
    
}