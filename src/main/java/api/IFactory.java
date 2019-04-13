package api;

import lib.internalApi.IInstance;

public interface IFactory {

    public IInstance createArchaetype();

    public abstract String getBaseName();

    public abstract String getFactoryAssetId();

}