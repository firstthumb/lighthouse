package net.javaci.lighthouse.node;

import net.javaci.lighthouse.node.command.Command;
import net.javaci.lighthouse.node.output.CommandOutput;
import net.javaci.lighthouse.node.request.CommandFactory;
import net.javaci.lighthouse.node.request.CommandRequest;
import org.jboss.netty.channel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: ekocaman
 * Date: 5/27/13
 */
public class ClientHandler extends SimpleChannelUpstreamHandler {
    private static Logger logger = LoggerFactory.getLogger(ClientHandler.class);

    @Override
    public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        super.handleUpstream(ctx, e);
    }

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        logger.info("Connected to the server");

        super.channelConnected(ctx, e);
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        System.out.println("I got message from SERVER : " + e.getMessage());

        if (e.getMessage() instanceof CommandRequest) {
            CommandRequest request = (CommandRequest) e.getMessage();
            Command command = CommandFactory.getInstance().getCommand(request);

            if (command == null) {
                logger.error("Command not identified : " + request);
            } else {
                command.init();
                CommandOutput output = command.execute(ctx.getChannel(), request.getParameters());

                ctx.getChannel().write(output);
            }
        } else {
            logger.error("Wrong Object received. It should be " + CommandRequest.class + " Type");
        }
    }

    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelClosed(ctx, e);
        System.out.println("Closed");
    }
}
