package net.javaci.lighthouse.plugin.example;

import net.javaci.lighthouse.plugin.ApplicationPlugin;

/**
 * User: ekocaman
 * Date: 5/23/13
 */
public class SystemTimePlugin implements ApplicationPlugin {

    public String getName() {
        return "SystemTimePlugin";
    }

    public void init() {
        System.out.println("Initialized SystemTimePlugin");
    }
}
