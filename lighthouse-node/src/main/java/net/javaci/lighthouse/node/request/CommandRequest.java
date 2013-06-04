package net.javaci.lighthouse.node.request;

import java.io.Serializable;
import java.util.HashMap;

/**
 * User: ekocaman
 * Date: 6/4/13
 */
public class CommandRequest implements Serializable {
    private CommandType commandType;
    private HashMap<String, String> parameters = new HashMap<String, String>();

    public CommandRequest(CommandType commandType) {
        this.commandType = commandType;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public HashMap<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, String> parameters) {
        this.parameters = parameters;
    }
}
