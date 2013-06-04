package net.javaci.lighthouse.node;

import net.javaci.lighthouse.node.command.Command;
import net.javaci.lighthouse.node.command.ListPluginsCommand;
import net.javaci.lighthouse.node.request.CommandRequest;

/**
 * User: ekocaman
 * Date: 6/4/13
 */
public class CommandFactory {

    private static CommandFactory instance;

    private CommandFactory() {}

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }

        return instance;
    }

    public Command getCommand(CommandRequest request) {
        switch (request.getCommandType()) {
            case LIST_PLUGINS:
                return new ListPluginsCommand();
        }

        return null;
    }
}
