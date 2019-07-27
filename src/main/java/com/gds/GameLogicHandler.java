package com.gds;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gds.net.BaseHandlerAdapter;

/**
 * 游戏服逻辑处理入口
 * @author tang
 */
@Sharable
public class GameLogicHandler extends BaseHandlerAdapter  {
	private Logger logger = LoggerFactory.getLogger(GameLogicHandler.class);


	/**
	 * 接收到消息
	 */
	@Override
	public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		System.out.println(msg.toString());
//		if(Config.shutDown){
//			ctx.channel().close();
//			return;
//		}
//		try{
//			Session session = ctx.channel().attr(AttributeKeyType.ROLE_SESSION).get();
//			if (session == null) {
//				logger.error("角色session不存在!");
//				ctx.channel().close();
//				return;
//			}
//			if(!(msg instanceof byte[])){
//				logger.warn("illegal ip:"+ctx.channel().remoteAddress());
//				ctx.channel().close();
//				return;
//			}
//	        CMsg cmsg = CMsg.parseFrom((byte[])msg);
//	        if (cmsg == null){
//	        	return;
//	        }
//	        if (!FireWall.check("")) {
//	        	ctx.channel().attr(AttributeKeyType.ROLE_SESSION).set(null);
//	        	ctx.channel().close();
//	        }
//	        Dispatcher.dispatch(session, cmsg.getCmd(), cmsg.getData());
//		}catch(Exception e){
//			logger.error("GameLogicHandler channelRead0 err. e=",e);
//		}
	}

	/**
	 * 成功连接
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
//		if (Config.shutDown || SessionCache.getOnlineCnt() >= SessionCache.onlineRoleMaxNum){
//			ctx.channel().close();
//			return;
//		}
//		Session session = new Session(ctx.channel(), null);
//		session.setLastTime(System.currentTimeMillis());
//		session.addAttr(SessionKey.IP, StringUtil.getIp(session.getChannel().remoteAddress()));
//		ctx.channel().attr(AttributeKeyType.ROLE_SESSION).set(session);
	}

	/**
	 * 断开连接
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//		Session session = ctx.channel().attr(AttributeKeyType.ROLE_SESSION).get();
//		if (session != null){
//			ctx.channel().attr(AttributeKeyType.ROLE_SESSION).set(null);
//			if(session.getCloseFlag() == 0){
//				RoleLogic.getInstance().doLogout(session);
//				logger.debug("+++++++close");
//			}
//		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		
	}
	
	
}
