package lib.internalApi.Instance;

import java.util.Optional;

import lib.dataStructures.*;
import lib.internalApi.Instance.IInventory;
import models.Item;
import models.Actor;
import lib.internalApi.Instance.IInstance;

public abstract class PhysicalInstance implements IInstance {

    //Phyiscal properties API

    public abstract double getWeight();

    public abstract double getVolume();

    public abstract double getTemperature();

    //API 


    /**
     * 
     * @return an optional interface to an inventory.
     */
    public abstract Optional<IInventory> getInventory();

    /**
     * 
     * @param attack The attack to be applied to the object
     */
    public abstract void applyAttack(SAttack attack);

    /**
     * 
     * @param attack The attack to be applied to the object
     * @param origin The origin of the  attack
     */
    public void applyAttack(SAttack attack, Actor origin) {
        applyAttack(attack);
    }

    /**
     * 
     * @param attack The attack to be applied to the object.
     * @param origin The origin of the attack.
     * @param item The item used in the attack.
     */
    public void applyAttack(SAttack attack, Actor origin, Item item) {
        applyAttack(attack, origin);
    }

    public abstract boolean activate();

    public boolean activate(Actor origin) {
        return activate();
    }

    public boolean activate(Actor origin, Item item) {
        return activate(origin);
    }

    public abstract String observe();

    public String observe(Actor actor) {
        return observe();
    }

    public abstract boolean hit(Actor projectile, SThrow thrower);

    public boolean hit(Actor projectile, SThrow thrower, Actor throwActor) {
        return hit(projectile, thrower);
    }


    /**
     *
     * @return The value of the item, or level of the actor
     */
    public abstract double getValue();

}