package net.javaci.lighthouse.frontend.server;

import net.javaci.lighthouse.node.request.CommandRequest;
import net.javaci.lighthouse.node.request.CommandType;
import org.jboss.netty.channel.*;

/**
 * User: ekocaman
 * Date: 5/27/13
 */
public class MyServerHandler extends SimpleChannelHandler {

    @Override
    public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        super.handleUpstream(ctx, e);
    }

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelConnected(ctx, e);
        System.out.println("Channel Connected");

        CommandRequest request = new CommandRequest(CommandType.LIST_PLUGINS);
        ctx.getChannel().write(request);
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        System.out.println("I received message from CLIENT : " + e.getMessage());
//        System.out.println("Now sending back to the CLIENT : " + new Date().getTime());

//        GetSystemTimeCommand command = (GetSystemTimeCommand)e.getMessage();
//
//        if (command.getMessage().equals("5")) {
//            ctx.getChannel().write(new InitializePluginsCommand("1"));
//        }
//        else {
//            ctx.getChannel().write(e.getMessage());
//        }
    }

    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelClosed(ctx, e);
        System.out.println("Channel Closed");
    }

    @Override
    public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e) {
//        e.getChannel().getPipeline().addFirst("decoder", new ObjectDecoder());
//        e.getChannel().getPipeline().addAfter("decoder", "encoder", new ObjectEncoder());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        super.exceptionCaught(ctx, e);
        System.out.println("EXCEPTION : " + e.getCause());
    }
}
