package net.javaci.lighthouse.frontend.server;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * User: ekocaman
 * Date: 6/4/13
 */
public class NodeServer {

    private ServerBootstrap bootstrap;
    private ChannelGroup channelGroup;

    public boolean start() {
        // Pretty standard Netty startup stuff...
        // boss/worker executors, channel factory, channel group, pipeline, ...
        Executor bossPool = Executors.newCachedThreadPool();
        Executor workerPool = Executors.newCachedThreadPool();
        ChannelFactory factory = new NioServerSocketChannelFactory(bossPool, workerPool);
        this.bootstrap = new ServerBootstrap(factory);

        this.channelGroup = new DefaultChannelGroup("-all-channels");

        this.bootstrap.setPipelineFactory(new MyPipelineFactory());

        Channel acceptor = this.bootstrap.bind(new InetSocketAddress(7856));
        if (acceptor.isBound()) {
            System.err.println("+++ SERVER - bound to *:12345");
            this.channelGroup.add(acceptor);
            return true;
        } else {
            System.err.println("+++ SERVER - Failed to bind to *:12345");
            this.bootstrap.releaseExternalResources();
            return false;
        }
    }

    public void stop() {
        this.channelGroup.close().awaitUninterruptibly();
        this.bootstrap.releaseExternalResources();
        System.err.println("+++ SERVER - Stopped.");
    }
}
