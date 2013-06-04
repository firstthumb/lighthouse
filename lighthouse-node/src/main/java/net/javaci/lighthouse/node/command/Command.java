package net.javaci.lighthouse.node.command;

import net.javaci.lighthouse.node.output.CommandOutput;
import org.jboss.netty.channel.Channel;

import java.io.Serializable;
import java.util.HashMap;

/**
 * User: ekocaman
 * Date: 5/28/13
 */
public abstract class Command implements Serializable {

    public void init() {}

    // TODO: channel parameter may be excluded
    public abstract CommandOutput execute(Channel channel, HashMap<String, String> parameters);
}
