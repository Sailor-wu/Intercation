package com.gds.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketEncoder extends MessageToMessageEncoder<byte[]> {
	private static final Logger logger = LoggerFactory.getLogger(WebSocketEncoder.class);
	

	@Override
	protected void encode(ChannelHandlerContext ctx, byte[] msg, List<Object> out) throws Exception {
		final byte[] data = (byte[]) msg;
		if (data.length == 0) {
			logger.warn("encoder write data err, len=0");
			return;
		}
		final ByteBuf byteBuf = ctx.alloc().buffer(data.length + 4);
		byteBuf.writeInt(data.length);
		byteBuf.writeBytes(data);
		out.add(new BinaryWebSocketFrame(byteBuf));
	}
}
