package lib.factories;

import api.IItemFactory;
import core.Game;
import models.Item;
import org.json.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;

public class ItemFactory<T extends Item> implements IItemFactory {

    Class<T> clazz;

    String assetId;

    public ItemFactory(Class<T> clazz, String assetId) {
        this.assetId = assetId;
        this.clazz = clazz;
    }

    @Override
    public Item createItem(JSONObject options) {
        try {
            Constructor<T> c = clazz.getConstructor(JSONObject.class);
            return c.newInstance(options);
        } catch (NoSuchMethodException e) {
            Game.logger.log(Level.WARNING, "Item " + clazz.getName() + " couldn\'t be created because it has no single-arg JSONObject Constructor");
        } catch (InstantiationException e) {
            Game.logger.log(Level.WARNING, "Item " + clazz.getName() + " couldn\'t be created due to Instantiation Exception");
        } catch (InvocationTargetException e) {
            Game.logger.log(Level.WARNING, "Item " + clazz.getName() + " couldn\'t be created due to InvocationTargetException");
        } catch (IllegalAccessException e) {
            Game.logger.log(Level.WARNING, "Item " + clazz.getName() + " couldn\'t be created due to IllegalAccessException");
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
