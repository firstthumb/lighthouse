package net.javaci.lighthouse.node.command;

import net.javaci.lighthouse.node.output.CommandOutput;
import org.jboss.netty.channel.Channel;

import java.util.HashMap;

/**
 * User: ekocaman
 * Date: 6/4/13
 */
public class ExecutePluginCommand extends Command {

    private String message;

    public ExecutePluginCommand(String message) {
        this.message = message;
    }

    public void execute() {
        System.out.println("Executing InitializePluginsCommand : " + message);
    }

    public String toString() {
        return "InitializePluginsCommand : " + message;
    }

    @Override
    public CommandOutput execute(Channel channel, HashMap<String, String> parameters) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
