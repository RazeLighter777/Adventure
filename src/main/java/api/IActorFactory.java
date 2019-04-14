package api;

import lib.internalApi.Position;
import models.Actor;
import org.json.JSONObject;
public interface IActorFactory extends IFactory {
    
    public Actor createActor(Position p, JSONObject options);
    
}