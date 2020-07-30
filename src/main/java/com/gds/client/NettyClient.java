package com.gds.client;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gds.net.BaseHandlerAdapter;
import com.gds.net.IODecoder;
import com.gds.net.IOEncoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.DefaultThreadFactory;

public class NettyClient {

	private static final Logger logger = LoggerFactory.getLogger(NettyClient.class);
	private static final EventLoopGroup group = new NioEventLoopGroup(1, new DefaultThreadFactory("clientGroup"));
	private static final Bootstrap boot = new Bootstrap();

	public static Channel middleChannel = null;

	// 游戏服与中央服的心跳间隔 秒
	public static int HEART_BEAT = 10;

	/**
	 * 启动中央服务器连接客服端
	 * 
	 * @throws Exception
	 */
	public static void start(BaseHandlerAdapter logicHandler) throws Exception {
		try {
			boot.group(group).channel(NioSocketChannel.class).option(ChannelOption.SO_KEEPALIVE, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new IdleStateHandler(0, HEART_BEAT, 0, TimeUnit.SECONDS));
							ch.pipeline().addLast(new IODecoder());
							ch.pipeline().addLast(new IOEncoder());
							ch.pipeline().addLast(logicHandler);
						}
					});
			// 连接服务器
			connectMiddle();
			
		} catch (Exception e) {
			throw new Exception("connect middle server err");
		}
		// 注册定时任务检测游戏服与中央服连接是否正常
		//	       ScheduleManager.register(new MiddleConnectionTask());
	}

	private static void sendMsg() {
		String msg = "hello,my netty";
		byte[] byts = msg.getBytes();
		if(middleChannel != null){
			middleChannel.writeAndFlush(byts);
		}
	}

	private static void connectMiddle() {
		try {
			if (middleChannel == null || !middleChannel.isActive()) {
				middleChannel = boot.connect("127.0.0.1", 8888).channel();
				sendMsg();
			}
		} catch (Exception e) {
			logger.error("start to connect middle server ", e);
		}
	}

	/**
	 * 关闭中央服务器服务
	 */
	public static void shutDown() {
		group.shutdownGracefully();
	}
	
	public static void main(String[] args) {
		try {
			NettyClient.start(new ClientMessageHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
