package net.javaci.lighthouse.node.command;

/**
 * User: ekocaman
 * Date: 6/4/13
 */
public class InitializePluginsCommand extends Command {

    private String message;

    public InitializePluginsCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute() {
        System.out.println("Executing InitializePluginsCommand : " + message);
    }

    public String toString() {
        return "InitializePluginsCommand : " + message;
    }
}
