package api;

import lib.internalApi.controls.BinaryDesisionControl;
import lib.internalApi.controls.OptionControl;
import lib.internalApi.controls.QuantityControl;
import lib.internalApi.controls.StringControl;

public interface IController {

    //Forces the controller to resolve one of these choices.

    void resolve(QuantityControl qc);

    void resolve(BinaryDesisionControl bc);

    void resolve(StringControl sc);

    void resolve(OptionControl oc);

    /**
     * Sends the controller an alert.
     * @param al the alert message.
     */
    void alert(String al);

    /**
     *
     * @param len The length of the vibration
     * @param intensity The intensity.
     */
    void vibrate(double len, double intensity);




}
