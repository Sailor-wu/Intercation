package com.gds.net;

import io.netty.channel.SimpleChannelInboundHandler;

public abstract class BaseHandlerAdapter extends SimpleChannelInboundHandler<Object>{
	
	public static final String WEB_SOCKET_PATH = "/websocket";

}
