package lib.internalApi.controls;

public class Result {

    public boolean succuessful;

    public boolean isFinal;

    public String text;

    public Result(boolean s, boolean f, String t) {
        succuessful = s;
        isFinal = f;
        text = t;
    }
}
