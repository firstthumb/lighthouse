package net.javaci.lighthouse.node;

import net.javaci.lighthouse.node.server.MyServerHandler;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.serialization.ClassResolvers;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;
import org.jboss.netty.handler.logging.LoggingHandler;

/**
 * User: ekocaman
 * Date: 5/27/13
 */
public class ClientPipelineFactory implements ChannelPipelineFactory {
    // stateless, singleton handler instances...re-used across connections
    private static final ChannelHandler STR_ENCODER = new ObjectEncoder();
    private static final ChannelHandler STR_DECODER = new ObjectDecoder(ClassResolvers.weakCachingConcurrentResolver(null));
    private static final ChannelHandler APP_HANDLER = new ClientHandler();
    private static final ChannelHandler LOG_HANDLER = new LoggingHandler();

    public ChannelPipeline getPipeline() throws Exception {
        // create default pipeline from static method
        ChannelPipeline pipeline = Channels.pipeline();

        // add logger to print incoming and outgoing data
        // this is both an upstream/downstream handler
//        pipeline.addLast("logger", LOG_HANDLER);

        // add delimiter-based frame decoder...this is stateful by maintaining
        // a buffer state of defragmented packets...thus, we create a new one each time
//        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(...));

        // add string encoder (downstream) /decoders (upstream)
        pipeline.addLast("decoder", STR_DECODER);
        pipeline.addLast("encoder", STR_ENCODER);

        // add business logic (upstream)
        pipeline.addLast("handler", APP_HANDLER);

        // return pipeline instance
        return pipeline;
    }
}