package lib.internalApi.Controls;

import api.IController;

/**
 * When the player is required to input a string. The string may be rejected if it has to conform to some regex.
 */
public abstract class StringControl extends Control {

    public StringControl(String t, String d, IController ic)  {
        super(d, t, ic);
    }

    public abstract Result select(String selection);

}
