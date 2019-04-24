package lib.internalApi.controls;

import api.IController;

public abstract class Control {

    public Control(String t, String d, IController ic) {
        title = t; description = d; controller = ic;
    }

    protected String description;

    protected String title;

    IController controller;

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }


}
