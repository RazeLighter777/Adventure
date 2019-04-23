package lib.internalApi.Controls;

import api.IController;

import java.lang.reflect.Constructor;

/**
 * For selections of a quantity.
 */
public abstract class QuantityControl extends Control {

    protected int[] range;

    public QuantityControl(String t, String d, IController ic, int[] r) {
        super(t, d, ic);
        range = r;
    }

    public abstract Result select(int num);


}
