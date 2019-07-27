package com.gds.net;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.concurrent.DefaultThreadFactory;

public class NettyServer {

	private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);
	/**主线程池 使用指定的线程数、给定的ThreadFactory*/
	private static final EventLoopGroup bossGroup = new NioEventLoopGroup(2, new DefaultThreadFactory("bossGroup"));
	/**工作线程池 使用指定的线程数、给定的ThreadFactory*/
	private static final EventLoopGroup workGroup = new NioEventLoopGroup(4, new DefaultThreadFactory("workGroup"));
	
	/**
	 * 开启服务器
	 * @param port
	 * @param logicHandler
	 * @param isWebSocket
	 * @throws Exception
	 */
	public static void start(int port, BaseHandlerAdapter logicHandler) throws Exception{
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.childOption(ChannelOption.TCP_NODELAY, true);
			b.group(bossGroup, workGroup).channel(NioServerSocketChannel.class);
				b.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
			        public void initChannel(SocketChannel ch) throws Exception {
			            ch.pipeline().addLast("http-codec", new HttpServerCodec());//HTTP解码器
			            ch.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));//将HTTP消息的多个部分合成一条完整的HTTP消息
			            ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());//支持大文件传输
			            ch.pipeline().addLast(new WebSocketServerProtocolHandler(BaseHandlerAdapter.WEB_SOCKET_PATH));
			            ch.pipeline().addLast("encoder", new WebSocketEncoder());
			            ch.pipeline().addLast("decoder", new WebSocketDecoder());
			            ch.pipeline().addLast("handler", logicHandler);
			        }
				});
				
			//服端口
			b.bind(port);
			logger.info("net server start succ, port:"+port);
		} catch (Exception e) {
			throw new Exception("start net server err",e);
		}
	}

	/**
	 * 关闭服务
	 */
	public static void shutDown(){
		bossGroup.shutdownGracefully();
		workGroup.shutdownGracefully();
	}
}

//			if(isWebSocket){
//			}else{
//				b.childHandler(new ChannelInitializer<SocketChannel>() {
//					@Override
//					public void initChannel(SocketChannel ch) throws Exception {
//						ch.pipeline().addLast(new IdleStateHandler(MiddleClient.HEART_BEAT * 2, 0, 0, TimeUnit.SECONDS));
//						ch.pipeline().addLast(new IODecoder());
//						ch.pipeline().addLast(logicHandler);
//						ch.pipeline().addLast(new IOEncoder());
//					}
//				});
//			}