package lib.dataStructures;

public final class SNutrition {

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