package com.gds;

import com.gds.net.NettyServer;

/**
 * .主程序入口
 * @author wu
 * @date Create in 2019/07/02 16:31:37
 *
 */
public class ApplicationStart {

	public static void main(String[] args) {
		
		try {
			NettyServer.start(8888,new GameLogicHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
