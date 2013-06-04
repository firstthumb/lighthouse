package net.javaci.lighthouse.node;

import net.javaci.lighthouse.node.command.GetSystemTimeCommand;
import net.javaci.lighthouse.node.command.InitializePluginsCommand;
import net.javaci.lighthouse.plugin.ApplicationPlugin;
import net.javaci.lighthouse.plugin.PluginService;
import net.javaci.lighthouse.plugin.PluginServiceFactory;
import org.jboss.netty.channel.*;

import java.util.Iterator;

/**
 * User: ekocaman
 * Date: 5/27/13
 */
public class ClientHandler extends SimpleChannelUpstreamHandler {

    @Override
    public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        super.handleUpstream(ctx, e);
    }

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("Connected");

        super.channelConnected(ctx, e);
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        System.out.println("I got message from SERVER : " + e.getMessage());

        if (e.getMessage() instanceof InitializePluginsCommand) {
            PluginService pluginService = PluginServiceFactory.createPluginService();

            Iterator<ApplicationPlugin> iter = pluginService.getPlugins();

            while (iter.hasNext()) {
                ApplicationPlugin plugin = pluginService.getPlugins().next();
                plugin.init();
                ctx.getChannel().write(new GetSystemTimeCommand("Name : " + plugin.getName()));
            }
        }
    }

    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelClosed(ctx, e);

    }
}
