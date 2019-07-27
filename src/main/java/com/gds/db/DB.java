package com.gds.db;

import java.util.Properties;

import com.gds.Config;
import com.gds.utils.PropertiesUtil;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * 初始化sqlmap配置文件类
 */
public class DB {
	private static SqlMapClient sqlMap = null;
	private static SqlMapClient sqlMapAdmin = null;

	static {
		try{
			Properties properties = PropertiesUtil.getProperties("db.properties");
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(Resources.getResourceAsReader("sqlmap-config.xml"), properties);
			if(!Config.IS_MIDDLE){
				Properties properties2 = PropertiesUtil.getProperties("db_admin.properties");
				if(properties2 != null){
					sqlMapAdmin = SqlMapClientBuilder.buildSqlMapClient(Resources.getResourceAsReader("sqlmap-config-admin.xml"), properties2);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static final SqlMapClient getSqlMapClient() {
		return sqlMap;
	}
	
	public static final SqlMapClient getAdminSqlMapClient() {
		return sqlMapAdmin;
	}
}
