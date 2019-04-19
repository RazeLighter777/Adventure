package core;

import java.io.*;

import api.IPlugin;

public final class ClassLoadingObjectInputStream extends ObjectInputStream {

    //This should contain all of the classes in the entire game, including all plugin jars.
    private ClassLoader loader;

    public ClassLoadingObjectInputStream(InputStream inputStream)
            throws IOException {
        super(inputStream);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException,
            ClassNotFoundException {
        Game game = Game.getInstance();
        for (IPlugin pl : game.plugins) {
            for (Class<?> c : pl.getClasses()) {
                if (c.getName().equals(desc.getName())) {
                    return c;
                }
            }
        }
        return super.resolveClass(desc);
    }
}
