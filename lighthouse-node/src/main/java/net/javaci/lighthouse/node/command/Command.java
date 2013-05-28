package net.javaci.lighthouse.node.command;

import java.io.Serializable;

/**
 * User: ekocaman
 * Date: 5/28/13
 */
public abstract class Command implements Serializable {

    public abstract void execute();
}
