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
public class DirectoryListPlugin implements ApplicationPlugin {

    public String getName() {
        return "DirectoryListPlugin";
    }

    public void init(HashMap<String, String> params) {
        System.out.println("Initialized DirectoryListPlugin");
    }

    @Override
    public PluginResult execute(HashMap<String, String> params) {
        PluginResult result = new PluginResult();

        result.setMessage("Files and Folders");

        result.getValues().put("Folders", "");
        result.getValues().put("Files", "");

        result.setResultType(PluginResultType.SUCCESS);

        return result;
    }
}
