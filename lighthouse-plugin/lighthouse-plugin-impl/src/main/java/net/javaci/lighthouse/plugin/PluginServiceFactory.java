package net.javaci.lighthouse.plugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: ekocaman
 * Date: 5/23/13
 */
public class PluginServiceFactory {
    public static PluginService createPluginService() {
        addPluginJarsToClasspath();
        return StandardPluginService.getInstance();
    }

    private static void addPluginJarsToClasspath() {
        try {
            //add the plugin directory to classpath
            ClasspathUtils.addDirToClasspath(new File("plugins"));
        } catch (IOException ex) {
            Logger.getLogger(PluginServiceFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
