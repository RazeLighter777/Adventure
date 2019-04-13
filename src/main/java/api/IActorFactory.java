package api;

import lib.internalApi.Position;
import models.Actor;
public interface IActorFactory extends IFactory {
    
    public Actor createActor(Position p);
    
}