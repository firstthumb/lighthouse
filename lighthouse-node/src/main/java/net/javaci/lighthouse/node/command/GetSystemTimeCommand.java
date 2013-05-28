package net.javaci.lighthouse.node.command;

import java.util.Date;

/**
 * User: ekocaman
 * Date: 5/28/13
 */
public class GetSystemTimeCommand extends Command {

    @Override
    public void execute() {
        System.out.println("System Time" + new Date());
    }

    public String toString() {
        return this + " : " + new Date();
    }
}
