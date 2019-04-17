package api;

import lib.internalApi.Instance.IInstance;

public interface IFactory {

    public IInstance createArchaetype();

    public abstract String getBaseName();

    public abstract String getFactoryAssetId();

}