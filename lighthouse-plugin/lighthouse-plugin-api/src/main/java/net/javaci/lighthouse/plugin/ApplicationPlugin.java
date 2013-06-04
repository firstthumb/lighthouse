package net.javaci.lighthouse.plugin;

import java.util.HashMap;

/**
 * User: ekocaman
 * Date: 5/23/13
 */
public interface ApplicationPlugin {

    String getName();

    void init(HashMap<String, String> params);

    PluginResult execute(HashMap<String, String> params);
}
