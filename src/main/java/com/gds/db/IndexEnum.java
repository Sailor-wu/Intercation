package com.gds.db;
/**
 * 索引类型
 * @author yxh
 *
 */
public enum IndexEnum {
	NORMAL,//普通索引
	UNIQUE,//唯一索引
	PRIMARY,//需要自增的主键
	DPRIMARY,//组合主键
	PRI//不用设置自启的主键
}
