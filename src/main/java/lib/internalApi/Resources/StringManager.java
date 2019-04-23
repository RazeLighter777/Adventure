package lib.internalApi.Resources;

import core.Game;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

public class StringManager {

    private static StringManager mgr = new StringManager();

    public HashMap<String, JSONObject> bundles;

    private static final String path = "strings";

    public static StringManager getInstance() {
        return mgr;
    }

    public StringManager() {
        bundles = new HashMap<>();
    }

    public boolean loadBundle(String bundle) {
        if (bundles.containsKey(bundle)) {
            return true;
        }
        try {
            FileInputStream ifstream = new FileInputStream(path + "/" + bundle);
            JSONTokener tokener = new JSONTokener(ifstream);
            JSONObject object = new JSONObject(tokener);
            bundles.put(bundle, object);
        } catch (IOException e) {
            Game.logger.log(Level.WARNING, "Unable to load resource bundle " + bundle);
            return false;
        }
        return true;
    }

    public String loadString(String bundle, String key) {
        if (!loadBundle(bundle)) {
            return new String("Missing Bundle");
        }
        return bundles.get(bundle).getString(key);
    }


}
