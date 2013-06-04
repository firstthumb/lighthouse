package net.javaci.lighthouse.node.command;

import java.util.Date;

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

    @Override
    public void execute() {
        System.out.println("System Time" + date);
    }

    public String toString() {
        return " Message: " + message + " " + date.getTime();
    }
}
