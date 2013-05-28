package net.javaci.lighthouse.node.server;

import org.jboss.netty.channel.*;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;

/**
 * User: ekocaman
 * Date: 5/27/13
 */
public class MyServerHandler extends SimpleChannelHandler {

    @Override
    public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        super.handleUpstream(ctx, e);
        System.out.println("Connected");
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        System.out.println("Received : " + e.getMessage());
    }

    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelClosed(ctx, e);
        System.out.println("Closed");
    }

    @Override
    public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e) {
//        e.getChannel().getPipeline().addFirst("decoder", new ObjectDecoder());
//        e.getChannel().getPipeline().addAfter("decoder", "encoder", new ObjectEncoder());
    }
}
