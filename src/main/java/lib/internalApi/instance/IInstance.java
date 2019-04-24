package lib.internalApi.instance;

import org.json.JSONObject;

import java.util.Optional;

public interface IInstance {

    void update();
    
    String getFullName();

    String getBaseName();

    Optional<String> getFactoryAssetId();

    String getGeneralDescription();

    String getDetailedDescription();

    void receiveDeletionRequest();

    Optional<JSONObject> queryProperty();
    
}