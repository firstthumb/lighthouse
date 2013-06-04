package net.javaci.lighthouse.node.output;

/**
 * User: ekocaman
 * Date: 6/4/13
 */
public class SimpleCommandOutput extends CommandOutput {

    private String message;

    public SimpleCommandOutput() {}

    public SimpleCommandOutput(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SimpleCommandOutput{" +
                "message='" + message + '\'' +
                '}';
    }
}
