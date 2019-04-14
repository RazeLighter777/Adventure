package models;

import java.io.Serializable;

import lib.internalApi.PhysicalInstance;
import java.util.Optional;
import lib.dataStructures.*;

public abstract class Item extends PhysicalInstance implements Serializable {


    public static final long serialVersionUID = 1;

    //API 
    
    public Optional<SNutrition> eat(Actor eater) {
        return Optional.empty();
    }


}