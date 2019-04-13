package lib.internalApi;

import lib.dataStructures.*;
import models.Item;
import models.Actor;
import lib.internalApi.IInstance;

public abstract class PhysicalInstance implements IInstance {

    //Phyiscal properties API

    public abstract double getWeight();

    public abstract double getVolume();

    public abstract double getTemperature();

    //API 

    public abstract void applyAttack(SAttack attack);

    public void applyAttack(SAttack attack, Actor origin) {
        applyAttack(attack);
    }

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

}