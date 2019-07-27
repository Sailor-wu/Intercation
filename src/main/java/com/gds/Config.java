package com.gds;


import com.gds.utils.DateTimeUtil;
import com.gds.utils.PropertiesUtil;
import com.gds.utils.StringUtil;

import java.util.Arrays;
import java.util.Properties;

public class Config {
	//停服标识
	public static volatile boolean shutDown = false;
	
	/** 区号 (固定6位，前2位标识渠道10~99，后4位标识真实区，0001~9999）*/
	public static int SVR_ID = 0;
	/** 服务器IP */
	public static String SVR_IP = "127.0.0.1";
	/** 游戏主端口 */
	public static int SVR_PORT = 0;	
	/** 是否测试服 */
	public static boolean IS_TEST;
	/** 防沉迷标识 */
	public static boolean IS_ANTI;
	/** 平台号  */
	public static int PLATFORM;
	/** 渠道 */
	public static String PID = "";
	/** GM是否开启 */
	public static boolean IS_GM = false;
	/** 登录验证key */
	public static String AUTH_KEY = "";
	/** 版署 */
	public static boolean isBanShu;
	/** 防火墙 */
	public static boolean FIRE_WARLL;
	
	
	/**
	 * 逻辑线程池线程数
	 */
	public static byte WORK_POOL_SIZE = 8;
	public static byte BATTLE_POOL_SIZE = 2;
	public static byte SKIP_BATTLE_POOL_SIZE = 4;
	
	
	
	/****************后台相关配置*****************/
	/**后台地址*/
	public static String ADMIN_URL = "";
	/**后台调用游戏服端口 */
	public static int ADMIN_PORT = 0;
	/**后台调用游戏服充值端口 */
	public static int RECHARGE_PORT = 0;
	/**后台和游戏服通信私密key*/
	public static String ADMIN_HTTP_KEY = "";
	
	
	/****************中央服服相关配置*****************/
	/** 是否中央服 */
	public static boolean IS_MIDDLE = false;
	/** 中央服务器IP */
	public static String MIDDLE_IP = null;
	/** 中央服务器端口 */
	public static int MIDDLE_PORT = 0;
	/** 中央服务器rpc端口 */
	public static int RPC_PORT = 0;
	
	
	/****************动态设置*****************/
	/**开服时间*/
	public static int OPEN_TIME = 0;
	/**合服时间*/
	public static int MERGE_TIME;
	/**合并svrId，如100001_100002*/
	public static String MERGE_SVR;
	
	
	/**
	 * 获取开服天数
	 * @return
	 */
	public static int getOpenServerDays(){
		if(OPEN_TIME == 0){
			return 0;
		}
		int todayZeroTime = DateTimeUtil.getTodayZeroTimeInt();
		if(OPEN_TIME > todayZeroTime){
			return 0;
		}
        return DateTimeUtil.getDayBetween(OPEN_TIME, todayZeroTime)+1;
	}
	
	/**
	 * 是否在同一个服务器
	 * @param svrId1
	 * @param svrId2
	 * @return
	 */
	public static boolean isSameServer(int svrId1, int svrId2){
		if(svrId1 == svrId2){
			return true;
		}
		if(StringUtil.isBlank(MERGE_SVR)){
			return false;
		}
		int[] svrArr = StringUtil.toIntArr(MERGE_SVR, "_");
		int index1 = Arrays.binarySearch(svrArr, svrId1);
		int index2 = Arrays.binarySearch(svrArr, svrId2);
		return index1 >= 0 && index2 >= 0;
	}
	
	
	public static void init(String fileName){
		Properties p = PropertiesUtil.getProperties("game.properties");
		if(p.containsKey("svrId")){
			SVR_ID = Integer.parseInt(p.getProperty("svrId"));
		}
		if(p.containsKey("svrIp")){
			SVR_IP = p.getProperty("svrIp");
		}
		if(p.containsKey("svrPort")){
			SVR_PORT = Integer.parseInt(p.getProperty("svrPort"));
		}
		if(p.containsKey("isTest")){
			IS_TEST = Boolean.parseBoolean(p.getProperty("isTest"));
		}
		if(p.containsKey("isAnti")){
			IS_ANTI = Boolean.parseBoolean(p.getProperty("isAnti"));
		}
		if(p.containsKey("isGm")){
			IS_GM = Boolean.parseBoolean(p.getProperty("isGm"));
		}
		if(p.containsKey("isBanShu")){
			isBanShu = Boolean.parseBoolean(p.getProperty("isBanShu"));
		}
		if(p.containsKey("fireWall")){
			FIRE_WARLL = Boolean.parseBoolean(p.getProperty("fireWall"));
		}
		if(p.containsKey("workPoolSize")){
			WORK_POOL_SIZE = Byte.parseByte(p.getProperty("workPoolSize"));
		}
		if(p.containsKey("battlePoolSize")){
			BATTLE_POOL_SIZE = Byte.parseByte(p.getProperty("battlePoolSize"));
		}
		if(p.containsKey("platform")){
			PLATFORM = Integer.parseInt(p.getProperty("platform"));
		}
		if(p.containsKey("authKey")){
			AUTH_KEY = p.getProperty("authKey");
		}
		if(p.containsKey("adminUrl")){
			ADMIN_URL = p.getProperty("adminUrl");
		}
		if(p.containsKey("adminPort")){
			ADMIN_PORT = Integer.parseInt(p.getProperty("adminPort"));
		}
		if(p.containsKey("rechargePort")){
			RECHARGE_PORT = Integer.parseInt(p.getProperty("rechargePort"));
		}
		if(p.containsKey("adminHttpKey")){
			ADMIN_HTTP_KEY = p.getProperty("adminHttpKey");
		}
		
		if(p.containsKey("middleIp")){
			MIDDLE_IP = p.getProperty("middleIp");
		}
		if(p.containsKey("middlePort")){
			MIDDLE_PORT = Integer.parseInt(p.getProperty("middlePort"));
		}
		if(p.containsKey("rpcPort")){
			RPC_PORT = Integer.parseInt(p.getProperty("rpcPort"));
		}
		if(p.containsKey("isMiddle")){
			IS_MIDDLE = Boolean.parseBoolean(p.getProperty("isMiddle"));
		}
	}
}
