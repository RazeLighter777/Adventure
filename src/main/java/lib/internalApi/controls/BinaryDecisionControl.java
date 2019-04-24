package lib.internalApi.controls;

import api.IController;

/**
 * For immediate binary desisions, must be made before anything else.
 */
public abstract class BinaryDecisionControl extends Control {

    public BinaryDecisionControl(String t, String d, IController ic) {
        super(t, d, ic);
    }

    public abstract Result select(boolean choice);

}
