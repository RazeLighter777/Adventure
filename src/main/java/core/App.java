package core;

import java.util.Date;
import java.util.logging.Logger;


import implementations.environment.World;

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
        System.out.println( "Hello World!" );
    }
}
