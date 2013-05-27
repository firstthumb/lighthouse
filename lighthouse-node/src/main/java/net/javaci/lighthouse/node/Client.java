package net.javaci.lighthouse.node;

import net.javaci.lighthouse.node.server.MyPipelineFactory;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.frame.DelimiterBasedFrameDecoder;
import org.jboss.netty.handler.codec.frame.Delimiters;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * User: ekocaman
 * Date: 5/27/13
 */
public class Client {
    private ClientBootstrap bootstrap;
    private Channel connector;

    public boolean start() {
        Executor bossPool = Executors.newCachedThreadPool();
        Executor workerPool = Executors.newCachedThreadPool();
        ChannelFactory factory = new NioClientSocketChannelFactory(bossPool, workerPool);
        this.bootstrap = new ClientBootstrap(factory);

        this.bootstrap.setPipelineFactory(new MyPipelineFactory());

        // Declared outside to fit under 80 char limit
//        final DelimiterBasedFrameDecoder frameDecoder = new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter());
//        this.bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
//            public ChannelPipeline getPipeline() throws Exception {
//                return Channels.pipeline(
//                        frameDecoder,
//                        new StringEncoder(),
//                        new ClientHandler());
//            }
//        });

        ChannelFuture future = this.bootstrap.connect(new InetSocketAddress("localhost", 7856));
        if (!future.awaitUninterruptibly().isSuccess()) {
            System.out.println("--- CLIENT - Failed to connect to server at " + "localhost:12345.");
            this.bootstrap.releaseExternalResources();
            return false;
        }

        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    channelFuture.getChannel().write("MessageFromClient");
                }
            }
        });

        this.connector = future.getChannel();
        return this.connector.isConnected();
    }

    public void stop() {
        if (this.connector != null) {
            this.connector.close().awaitUninterruptibly();
        }
        this.bootstrap.releaseExternalResources();
        System.out.println("--- CLIENT - Stopped.");
    }

    public boolean sendMessage(String message) {
        if (this.connector.isConnected()) {
            // Append \n if it's not present, because of the frame delimiter
            if (!message.endsWith("\n")) {
                this.connector.write(message + '\n');
            } else {
                this.connector.write(message);
            }
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();

        client.sendMessage("Message2");
    }
}
