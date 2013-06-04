package net.javaci.lighthouse.node.command;

import net.javaci.lighthouse.node.output.CommandOutput;
import net.javaci.lighthouse.node.output.SimpleCommandOutput;
import net.javaci.lighthouse.plugin.ApplicationPlugin;
import net.javaci.lighthouse.plugin.PluginService;
import net.javaci.lighthouse.plugin.PluginServiceFactory;
import org.jboss.netty.channel.Channel;

import java.util.HashMap;
import java.util.Iterator;

/**
 * User: ekocaman
 * Date: 6/4/13
 */
public class ListPluginsCommand extends Command {

    @Override
    public CommandOutput execute(Channel channel, HashMap<String, String> parameters) {
        SimpleCommandOutput output = new SimpleCommandOutput();

        PluginService pluginService = PluginServiceFactory.createPluginService();
        Iterator<ApplicationPlugin> iterator = pluginService.getPlugins();

        String message = "";
        while (iterator.hasNext()) {
            ApplicationPlugin plugin = iterator.next();
            message += plugin.getName() + ",";
        }

        output.setMessage(message);

        return output;
    }
}
