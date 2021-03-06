package net.javaci.lighthouse.node;

import net.javaci.lighthouse.node.command.GetSystemTimeCommand;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * User: ekocaman
 * Date: 5/27/13
 */
public class Client {
    private static Logger logger = LoggerFactory.getLogger(Client.class);

    private ClientBootstrap bootstrap;
    private Channel connector;

    public boolean start() {
        Executor bossPool = Executors.newCachedThreadPool();
        Executor workerPool = Executors.newCachedThreadPool();
        ChannelFactory factory = new NioClientSocketChannelFactory(bossPool, workerPool);
        this.bootstrap = new ClientBootstrap(factory);

        this.bootstrap.setPipelineFactory(new ClientPipelineFactory());

        ChannelFuture future = this.bootstrap.connect(new InetSocketAddress("localhost", 7856));
        if (!future.awaitUninterruptibly().isSuccess()) {
            System.out.println("--- CLIENT - Failed to connect to server at " + "localhost:12345.");
            this.bootstrap.releaseExternalResources();
            return false;
        }

//        future.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture channelFuture) throws Exception {
//                if (channelFuture.isSuccess()) {
//                    channelFuture.getChannel().write("MessageFromClient");
//                }
//            }
//        });

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

    public boolean sendMessage(Object message) {
        if (this.connector.isConnected()) {
            // Append \n if it's not present, because of the frame delimiter
//            if (!message.endsWith("\n")) {
//                this.connector.write(message + '\n');
//            } else {
            this.connector.write(message);
//            }
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        client.start();

//        client.sendMessage(new GetSystemTimeCommand("Starter"));
//
//        for (int i = 0; i < 10; i++) {
//            Thread.sleep(3000);
//            System.out.println("Message sent : " + new Date().getTime());
//            client.sendMessage(new GetSystemTimeCommand(i + ""));
//        }
    }
}
