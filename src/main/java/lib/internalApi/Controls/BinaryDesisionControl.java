package lib.internalApi.Controls;

import api.IController;

/**
 * For immediate binary desisions, must be made before anything else.
 */
public abstract class BinaryDesisionControl extends Control {

    public BinaryDesisionControl(String t, String d, IController ic) {
        super(t, d, ic);
    }

    public abstract Result select(boolean choice);

}
