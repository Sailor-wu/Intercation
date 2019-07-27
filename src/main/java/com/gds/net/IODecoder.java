package com.gds.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;


public class IODecoder extends ByteToMessageDecoder  {
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		if (in.readableBytes() < 4){
			return;
		}
		in.markReaderIndex();//标记一个read位置
		int dataLength = in.readInt();
		if (in.readableBytes() < dataLength) {
			// 长度不够则重置readerIndex
			in.resetReaderIndex();
			return;
		}
		byte [] decode = new byte[dataLength];
		in.readBytes(decode);
		out.add(decode);
	}
}
