package lib.factories;

import api.IActorFactory;
import core.Game;
import lib.internalApi.Environment.Position;
import models.Actor;
import org.json.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;

public class ActorFactory<T extends Actor> implements IActorFactory {

    Class<T> clazz;

    String assetId;

    public ActorFactory(Class<T> clazz, String assetId) {
        this.assetId = assetId;
        this.clazz = clazz;
    }

    @Override
    public Actor createActor(Position p, JSONObject options) {
        try {
            Constructor<T> c = clazz.getConstructor(Position.class, JSONObject.class);
            return c.newInstance(p, options);
        } catch (NoSuchMethodException e) {
            Game.logger.log(Level.WARNING, "Actor " + clazz.getName() + " couldn\'t be created because it has no dual-arg Position / JSONObject Constructor");
        } catch (InstantiationException e) {
            Game.logger.log(Level.WARNING, "Actor " + clazz.getName() + " couldn\'t be created due to Instantiation Exception");
        } catch (InvocationTargetException e) {
            Game.logger.log(Level.WARNING, "Actor " + clazz.getName() + " couldn\'t be created due to InvocationTargetException");
            Game.logger.log(Level.WARNING, "Cause: " + e.getCause().toString());
        } catch (IllegalAccessException e) {
            Game.logger.log(Level.WARNING, "Actor " + clazz.getName() + " couldn\'t be created due to IllegalAccessException");
        }
        return null;
    }


    @Override
    public String getBaseName() {
        return clazz.getName();
    }

    @Override
    public String getFactoryAssetId() {
        return assetId;
    }
}
