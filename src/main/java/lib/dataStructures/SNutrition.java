package lib.dataStructures;

import java.io.Serializable;

public final class SNutrition implements Serializable {

    public static final long serialVersionUID = 1;


    public double fat;

    public double sugar;

    public double starch;

    public double protein;

    public SNutrition(int f, int s, int st, int p) {
        fat = f;
        sugar = s;
        starch = st;
        protein = p;
    }

    public double getCalories() {
        return 9*fat + 
        3*starch + 
        4*protein +
        4*sugar;
    }
}