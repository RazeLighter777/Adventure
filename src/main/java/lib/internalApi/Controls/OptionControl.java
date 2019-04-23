package lib.internalApi.Controls;

import api.IController;

import java.util.ArrayList;

/**
 * For selecting an option and executing an action
 */
public abstract class OptionControl extends Control {


    protected ArrayList<Option> options;

    public OptionControl(String t, String d, IController ic, ArrayList<Option> ops) {
        super(t, d, ic);
        options = ops;
    }

    public abstract Result selectOption(int index);

    public static class Option {

        public String description;

        public String title;

        public Option(String t, String d) {
            description = d; title = t;
        }
    }


}
