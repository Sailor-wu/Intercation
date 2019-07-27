package com.gds.db;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.gds.db.DB;

/**
 * 基础dao类型提供sqlmapClient
 */
public class BaseDao {
	private SqlMapClient sqlMapClient = DB.getSqlMapClient();
	private SqlMapClient sqlMapClient_admin = DB.getAdminSqlMapClient();
	protected static final Logger logger = LoggerFactory.getLogger(BaseDao.class);
	/**
	 * 获取sqlMapClient对象
	 * @return
	 */
	protected SqlMapClient getSqlMapClient(){
		return sqlMapClient;
	}
	
	protected SqlMapClient getSqlMapClient(boolean isAdmin){
		if(isAdmin){
			return sqlMapClient_admin;
		}else{
			return sqlMapClient;
		}
	}
	
	protected SqlMapClient getSqlMapClient_admin(){
		return sqlMapClient_admin;
	}
	
}
