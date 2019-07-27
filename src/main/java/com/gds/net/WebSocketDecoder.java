package com.gds.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;

import java.util.List;


public class WebSocketDecoder extends MessageToMessageDecoder<BinaryWebSocketFrame>  {

	@Override
	protected void decode(ChannelHandlerContext ctx, BinaryWebSocketFrame msg, List<Object> out) throws Exception {
		ByteBuf byteBuf = msg.content();
		if (byteBuf.readableBytes() < 4){
			return;
		}
		byteBuf.markReaderIndex();//标记一个read位置
		int dataLength = byteBuf.readInt();
		if (byteBuf.readableBytes() < dataLength) {
			// 长度不够则重置readerIndex
			byteBuf.resetReaderIndex();
			return;
		}
		byte [] decode = new byte[dataLength];
		byteBuf.readBytes(decode);
		out.add(decode);
	}
}
