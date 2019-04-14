package models;

import java.io.Serializable;

import lib.lambdas.IStatusLambda;

public abstract class StatusEffect implements Serializable {

    private IStatusLambda action;

    public StatusEffect(IStatusLambda a) {
        action = a;
    }

    public void apply(Actor a) {
        action.apply(a, getStrength());
    }

    public abstract int getDuration();

    public abstract String getEffectName();

    public abstract double getStrength();

}