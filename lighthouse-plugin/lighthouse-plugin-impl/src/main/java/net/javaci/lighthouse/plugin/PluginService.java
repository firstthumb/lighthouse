package net.javaci.lighthouse.plugin;

import java.util.Iterator;

/**
 * User: ekocaman
 * Date: 5/23/13
 */
public interface PluginService {
    Iterator<ApplicationPlugin> getPlugins();
    void initPlugins();
}
