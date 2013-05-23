package net.javaci.lighthouse.plugin;

import java.util.logging.Logger;

/**
 * User: ekocaman
 * Date: 5/23/13
 */
public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        loadPlugins();
    }

    private static void loadPlugins() {
        PluginService pluginService = PluginServiceFactory.createPluginService();
        pluginService.initPlugins();
    }
}
