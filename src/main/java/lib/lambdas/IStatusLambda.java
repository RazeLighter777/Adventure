package lib.lambdas;

import java.io.Serializable;

import models.Actor;

@FunctionalInterface
public interface IStatusLambda extends Serializable {

    /**
     *
     * @param target The target the status is executed on
     * @param strength The strength of the status effect
     */
    public void apply(Actor target, double strength);
    
}