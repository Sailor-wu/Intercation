package com.gds.db;

import com.gds.db.BaseDao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;


public class DDLDao extends BaseDao {
	private static final DDLDao instance = new DDLDao();
	private DDLDao(){}
	public static final DDLDao getInstance(){
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> showTables(boolean isAdmin) throws SQLException{
		return getSqlMapClient(isAdmin).queryForList("DDL.showTables");
	}
	
	public void createTable(String sql, boolean isAdmin) throws SQLException{
		getSqlMapClient(isAdmin).update("DDL.createTable",sql);
	}
	@SuppressWarnings("unchecked")
	public List<FieldStru> descTable(String tableName, boolean isAdmin){
		try {
			return getSqlMapClient(isAdmin).queryForList("DDL.descTable", tableName);
		} catch (SQLException e) {
			return null;
		}
	}
	
	public void addColumn(AlterColumn alterTable, boolean isAdmin) throws SQLException{
		getSqlMapClient(isAdmin).update("DDL.addColumn", alterTable);
	}
	
	public void modifyColumn(AlterColumn alterTable, boolean isAdmin) throws SQLException{
		getSqlMapClient(isAdmin).update("DDL.modifyColumn", alterTable);
	}
	
	public void dropColumn(String tbname, String fieldName, boolean isAdmin) throws SQLException{
		Map<String, String> map = new HashMap<String, String>();
		map.put("tbname", tbname);
		map.put("fieldName", fieldName);
		getSqlMapClient(isAdmin).update("DDL.dropColumn", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<KeyStru> showKeys(String tbname, boolean isAdmin) throws SQLException{
		return getSqlMapClient(isAdmin).queryForList("DDL.showKeys",tbname);
	}
	
	public void modifyIndex(String sql, boolean isAdmin) throws SQLException{
		getSqlMapClient(isAdmin).update("DDL.modifyIndex", sql);
	}
	
	public void dropIndex(String tbname,String keyname,boolean isAdmin) throws SQLException{
		Map<String, String> map = new HashMap<String, String>();
		map.put("tbname", tbname);
		map.put("keyname", keyname);
		getSqlMapClient(isAdmin).update("DDL.dropIndex", map);
	}
	
	/**
	 * 查找所有的起始值
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String,Long> findAutoIncrement(boolean isAdmin) throws SQLException{
		HashMap<String,Long> result = new HashMap<String, Long>();
		List<Map<?,?>> list = getSqlMapClient(isAdmin).queryForList("DDL.findAutoIncrement");
		if(list==null||list.isEmpty())return result;
		for(Map<?,?> map:list){
			String name = map.get("table_name").toString();
			long autoId = NumberUtils.toLong(map.get("auto_increment").toString());
			result.put(name.toLowerCase(),autoId);
		}
		return result;
	}
	
	/**
	 * 修改起始值id
	 * @param tbname
	 * @param autoId
	 * @throws SQLException
	 */
	public void alterAutoId(String tbname,long autoId,boolean isAdmin) throws SQLException{
		HashMap<String,Object> map = new HashMap<String,Object>(2);
		map.put("tbname", tbname);
		map.put("autoId", autoId);
		getSqlMapClient(isAdmin).update("DDL.alterAutoId", map);
	}
	
}
