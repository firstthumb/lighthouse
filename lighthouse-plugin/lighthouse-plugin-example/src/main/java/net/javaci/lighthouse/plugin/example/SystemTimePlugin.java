package net.javaci.lighthouse.plugin.example;

import net.javaci.lighthouse.plugin.ApplicationPlugin;
import net.javaci.lighthouse.plugin.PluginResult;
import net.javaci.lighthouse.plugin.PluginResultType;

import java.util.Date;
import java.util.HashMap;

/**
 * User: ekocaman
 * Date: 5/23/13
 */
public class SystemTimePlugin implements ApplicationPlugin {

    public String getName() {
        return "SystemTimePlugin";
    }

    public void init(HashMap<String, String> params) {
        System.out.println("Initialized SystemTimePlugin");
    }

    @Override
    public PluginResult execute(HashMap<String, String> params) {
        PluginResult result = new PluginResult();

        Date currentDate = getCurrentTime();

        result.setMessage("Current Date : " + currentDate);
        result.setResultType(PluginResultType.SUCCESS);

        return result;
    }

    private Date getCurrentTime() {
        return new Date();
    }
}
