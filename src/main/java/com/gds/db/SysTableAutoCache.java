package com.gds.db;

import java.util.EnumMap;

/**
 * 自曾缓存类
 * @author yxh
 *
 */
public class SysTableAutoCache {
	/**
	 * 起始id集合
	 */
	private static final EnumMap<AutoType,Long> autoMap = new EnumMap<AutoType, Long>(AutoType.class);
	/**
	 * 添加起始id
	 * @param type
	 * @param id
	 */
	public static final void addAutoId(AutoType type,long id){
		autoMap.put(type,id);
	}
	
	/**
	 * 获取起始id
	 * @param type
	 * @return
	 */
	public static final Long getAutoId(AutoType type){
		return autoMap.get(type);
	}
	
	/**
	 * 销毁数据
	 */
	public static final void destory(){
		autoMap.clear();
	}
}
