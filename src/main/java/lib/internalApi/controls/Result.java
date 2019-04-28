package lib.internalApi.controls;

public class Result {

    private boolean valid;

    private boolean isFinal;

    private String text;

    public Result(boolean s, boolean f, String t) {
        valid = s;
        isFinal = f;
        text = t;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public boolean isValid() {
        return valid;
    }

    public String getText() {
        return text;
    }
}
