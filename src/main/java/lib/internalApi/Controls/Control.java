package lib.internalApi.Controls;

public abstract class Control {

    public Control(String t, String d) {
        title = t; description = d;
    }

    protected String description;

    protected String title;


    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }


}
