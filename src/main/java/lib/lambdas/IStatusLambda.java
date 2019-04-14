package lib.lambdas;

import java.io.Serializable;

import models.Actor;

@FunctionalInterface
public interface IStatusLambda extends Serializable {

    public void apply(Actor target, double strength);
    
}