package core;

import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{

    public static final Logger logger = Logger.getLogger("adventure-" + Date() + ".log");
    
    public static World getWorld() {
        throw new UnsupportedOperationException();
    }
    
    private static String Date() {
        return null;
    }

    public static void main(String[] args)
    {
        System.out.println(System.getProperty("user.dir"));
        System.out.println( "Hello World!" );
    }
}
