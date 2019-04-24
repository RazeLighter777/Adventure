package core;

import lib.internalApi.resources.StringManager;
import org.junit.Test;

public class StringManagerTest {

    @Test
    public void test() {
        System.out.println(System.getProperty("user.dir"));
        StringManager sm = new StringManager();
        sm.loadBundle("core.json");
        System.out.println(sm.loadString("core.json", "RockDescription"));
    }
}
