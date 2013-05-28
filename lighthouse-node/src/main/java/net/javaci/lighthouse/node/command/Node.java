package net.javaci.lighthouse.node.command;

import org.jboss.netty.channel.Channel;

/**
 * User: ekocaman
 * Date: 5/29/13
 */
public class Node {

    private Channel channel;

    public Node(Channel channel) {
        this.channel = channel;
    }
}
