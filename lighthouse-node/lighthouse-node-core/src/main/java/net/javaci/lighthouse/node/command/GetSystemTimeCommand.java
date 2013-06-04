package net.javaci.lighthouse.node.command;

import net.javaci.lighthouse.node.output.CommandOutput;
import org.jboss.netty.channel.Channel;

import java.util.Date;
import java.util.HashMap;

/**
 * User: ekocaman
 * Date: 5/28/13
 */
public class GetSystemTimeCommand extends Command {

    private String message;
    private Date date = new Date();

    public GetSystemTimeCommand(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void execute() {
        System.out.println("System Time" + date);
    }

    public String toString() {
        return " Message: " + message + " " + date.getTime();
    }

    @Override
    public CommandOutput execute(Channel channel, HashMap<String, String> parameters) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
