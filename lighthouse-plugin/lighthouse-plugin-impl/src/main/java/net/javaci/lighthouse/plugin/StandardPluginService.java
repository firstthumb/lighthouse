package net.javaci.lighthouse.plugin;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.logging.Logger;

/**
 * User: ekocaman
 * Date: 5/23/13
 */
public class StandardPluginService implements PluginService {

    private static StandardPluginService pluginService;
    private ServiceLoader<ApplicationPlugin> serviceLoader;
    private Logger logger = Logger.getLogger(getClass().getName());

    private StandardPluginService() {
        //load all the classes in the classpath that have implemented the interface
        serviceLoader = ServiceLoader.load(ApplicationPlugin.class);
    }

    public static StandardPluginService getInstance() {
        if (pluginService == null) {
            pluginService = new StandardPluginService();
        }
        return pluginService;
    }

    public Iterator<ApplicationPlugin> getPlugins() {
        return serviceLoader.iterator();
    }

    public void initPlugins() {
        Iterator<ApplicationPlugin> iterator = getPlugins();
        if (!iterator.hasNext()) {
            logger.info("No plugins were found!");
        }
        while (iterator.hasNext()) {
            ApplicationPlugin plugin = iterator.next();
            logger.info("Initializing the plugin " + plugin.getName());
            plugin.init();
        }
    }
}
