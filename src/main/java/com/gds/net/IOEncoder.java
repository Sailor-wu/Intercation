package com.gds.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IOEncoder extends ChannelOutboundHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(IOEncoder.class);
	
	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
		if(msg instanceof HttpResponse){
			ctx.writeAndFlush(msg);
			return;
		}
		final byte[] data = (byte[]) msg;
		if (data.length == 0) {
			logger.warn("encoder tcp write data err, len=0");
			return;
		}
		final ByteBuf byteBuf = ctx.alloc().buffer(data.length + 4);
		byteBuf.writeInt(data.length);
		byteBuf.writeBytes(data);
		ctx.writeAndFlush(byteBuf);
	}
}
