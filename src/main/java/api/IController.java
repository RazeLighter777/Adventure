package api;

import lib.internalApi.controls.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IController {

    /**
     * Sends the controller an alert.
     * @param al the alert message.
     */
    void alert(String title, String al);

    /**
     *
     * @param len The length of the vibration
     * @param intensity The intensity.
     */
    void vibrate(double len, double intensity);

    public class Controls {

        public ArrayList<QuantityControl> qc;

        public Controls(ArrayList<QuantityControl> qc, ArrayList<BinaryDecisionControl> bc, ArrayList<StringControl> sc, ArrayList<OptionControl> oc, ArrayList<MultipleSelectionControl> msc) {
            this.qc = qc;
            this.bc = bc;
            this.sc = sc;
            this.oc = oc;
            this.msc = msc;
        }

        public ArrayList<BinaryDecisionControl> bc;

        public ArrayList<StringControl> sc;

        public ArrayList<OptionControl> oc;

        public ArrayList<MultipleSelectionControl> msc;

    }

    void presentControls(Controls c);

    void resolve(BinaryDecisionControl bc);

    void resolve(StringControl sc);

    void resolve(OptionControl oc);

    void resolve(MultipleSelectionControl msc);



}
