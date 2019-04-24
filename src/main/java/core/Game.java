package core;

import java.util.ArrayList;
import java.util.logging.*;
import java.util.Enumeration;
import java.net.URLClassLoader;
import java.util.jar.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import api.IPlugin;
import environment.IWorld;
import lib.internalApi.resources.StringManager;
import org.json.*;

public final class Game {

    public static Logger logger = App.logger;

    private static Game gameInstance = new Game();

    private static final String gameDataPath = "game";

    private JSONObject gameJson;


    private World loadedWorld;

    public static Game getInstance() {
        return gameInstance;
    }

    public JSONObject queryGameProperty() {
        return gameJson;
    }
    public ArrayList<IPlugin> plugins;

    private StringManager stringManager = new StringManager();

    public StringManager getStringManager() {
        return stringManager;
    }

    public void beginGame(JSONObject options) {
        //Load the game properties.
        try {
            FileInputStream ifstream = new FileInputStream(gameDataPath + "/game.json");
            JSONTokener tokener = new JSONTokener(ifstream);
            gameJson = new JSONObject(tokener);
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Game failed to find game.json at path " + gameDataPath + "/game.json");
        }

        //plugins.add(new CorePlugin());
        stringManager.loadBundle("localization/core.json");
        logger = App.logger;
        JSONArray ja = (JSONArray)options.get("plugins");
        for (int i = 0; i < ja.length(); i++) {
             if (loadPlugin(ja.getString(i))) {
                logger.log(Level.INFO, plugins.get(plugins.size() - 1).getPluginName() + " was loaded");
            }
            
       }
    }

    public IWorld getWorldInterface() {
        return loadedWorld;
    }

    public boolean loadPlugin(String path) {
        try {
            JarFile jar = new JarFile(path);
            URL[] urls = { new URL("jar:file:" + path +"!/") };
            URLClassLoader cl = URLClassLoader.newInstance(urls);
            Enumeration<JarEntry> e = jar.entries();
            while (e.hasMoreElements()) {
                JarEntry je = e.nextElement();
                if (je.isDirectory() || !je.getName().endsWith(".class")) {
                    continue;
                }
                // -6 because of .class
                String className = je.getName().substring(0, je.getName().length() - 6);
                className = className.replace('/', '.');
                if (className.equals("Plugin")) {
                    @SuppressWarnings("unchecked")
                    Class<IPlugin> c = (Class<IPlugin>) cl.loadClass(className);
                    plugins.add(c.getDeclaredConstructor().newInstance());
                    return true;
                }
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error opening jarfile at path " + path);
        } catch (ClassCastException e) {
            logger.log(Level.WARNING, "ClassCastException, so wrong class type or something in jarfile at " + path);
        }
         catch (ClassNotFoundException e) {
            logger.log(Level.WARNING, "Could not find plugin class in plugin at path " + path);
        } catch (InstantiationException e) {
            logger.log(Level.WARNING, "Could not instantiate plugin class in plugin at path " + path);
        } catch (InvocationTargetException e) {
            logger.log(Level.WARNING, "InvocationTargetException in plugin class at path " + path);
        } catch (NoSuchMethodException e) {
            logger.log(Level.WARNING, "NoSuchMethodException in plugin class at path " + path);
        } catch (IllegalAccessException e) {
            logger.log(Level.WARNING, "IllegalAccessException in plugin class at path " + path);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Failed to load plugin because of error: " + e + " in plugin " + path);
        }
        return false;
    }

    public void saveGame() {

    }


}