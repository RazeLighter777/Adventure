package api;

import lib.internalApi.Controls.BinaryDesisionControl;
import lib.internalApi.Controls.OptionControl;
import lib.internalApi.Controls.QuantityControl;
import lib.internalApi.Controls.StringControl;

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
