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
import org.json.*;

public final class Game {

    static Logger logger = App.logger;

    public ArrayList<IPlugin> plugins;

    public void beginGame(JSONObject options) {
        //plugins.add(new CorePlugin());
        logger = App.logger;
        JSONArray ja = (JSONArray)options.get("plugins");
        for (int i = 0; i < ja.length(); i++) {
             if (loadPlugin(ja.getString(i))) {
                logger.log(Level.INFO, plugins.get(plugins.size() - 1).getPluginName() + " was loaded");
            }
            
       }
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
                if (className.contains("Plugin")) {
                    @SuppressWarnings("unchecked")
                    Class<IPlugin> c = (Class<IPlugin>) cl.loadClass(className);
                    plugins.add(c.getDeclaredConstructor().newInstance());
                    return true;
                }
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error opening jarfile at path " + path);
        } catch (ClassCastException e) {

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