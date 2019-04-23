package lib.internalApi.Controls;

import java.lang.reflect.Constructor;

/**
 * For selections of a quantity.
 */
public abstract class QuantityControl extends Control {

    protected int[] range;

    public QuantityControl(String t, String d, int[] r) {
        super(t, d);
        range = r;
    }

    public abstract Result select(int num);


}
