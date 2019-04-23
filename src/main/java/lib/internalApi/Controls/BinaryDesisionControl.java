package lib.internalApi.Controls;

/**
 * For immediate binary desisions, must be made before anything else.
 */
public abstract class BinaryDesisionControl extends Control {

    public BinaryDesisionControl(String t, String d) {
        super(t, d);
    }

    public abstract Result select(boolean choice);

}
