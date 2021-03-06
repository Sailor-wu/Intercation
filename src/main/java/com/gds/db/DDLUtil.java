package com.gds.db;

import com.gds.db.annotation.AdminSysTable;
import com.gds.db.annotation.ColumnBigInt;
import com.gds.db.annotation.ColumnFloat;
import com.gds.db.annotation.ColumnInt;
import com.gds.db.annotation.ColumnLongText;
import com.gds.db.annotation.ColumnSmallInt;
import com.gds.db.annotation.ColumnText;
import com.gds.db.annotation.ColumnTinyInt;
import com.gds.db.annotation.ColumnVar;
import com.gds.db.annotation.Index;
import com.gds.db.annotation.SysTable;
import com.gds.utils.ClassUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DDLUtil {
	private static final Logger logger = LoggerFactory.getLogger(DDLUtil.class);
	private static DDLDao ddlDao = DDLDao.getInstance();
	private static final String BL = " ";
	private static final String QU = ",";
	
	
	public static void initTableModel(Map<String, Class<?>> resMap, HashMap<String,Long> tabAutoMap, boolean isAdmin) throws Exception {
		checkTableAutoIncrement(tabAutoMap,resMap,isAdmin);
		checkField(resMap,isAdmin);
		checkIndex(resMap,isAdmin);
		//清空自增缓存
		SysTableAutoCache.destory();
	}

	private static void createTable(long autoId,String tbname, boolean utf8mb4, List<AlterColumn> alterTableList, boolean isAdmin) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append(tbname).append(BL);
		sb.append("(");
		String mtriKey = " PRIMARY KEY (";
		boolean needMtri = false;
		for (AlterColumn col : alterTableList) {
			IndexEnum key = col.getKey();
			sb.append(col.getField()).append(BL).append(col.getType()).append(BL).append(col.getIsNull()).append(BL);
			if (key == null || key != IndexEnum.PRIMARY) {
				sb.append(" ").append(col.getDefVal()).append(" ").append(BL);
			}
			sb.append("COMMENT \'").append(col.getComment()).append("\'");
			if (key != null) {
				if (key == IndexEnum.PRIMARY) {
					sb.append(BL).append("AUTO_INCREMENT").append(QU);
					sb.append("PRIMARY KEY").append(BL).append("(").append(col.getField()).append(")").append(QU);
				} else if (key == IndexEnum.NORMAL) {
					sb.append(QU).append("KEY").append(BL).append(col.getKeyName()).append(BL).append("(").append(col.getField()).append(")").append(QU);
				} else if (key == IndexEnum.UNIQUE) {
					sb.append(QU).append("UNIQUE KEY").append(BL).append(col.getKeyName()).append(BL).append("(").append(col.getField()).append(")").append(QU);
				} else if(key == IndexEnum.DPRIMARY){
					needMtri = true;
					sb.append(QU);
					mtriKey+=col.getField()+",";
				}else if(key == IndexEnum.PRI){//不设置自启值的id
					sb.append(QU).append("PRIMARY KEY").append(BL).append("(").append(col.getField()).append(")").append(QU);
				}
			} else {
				sb.append(QU);
			}
		}
		mtriKey = mtriKey.substring(0, mtriKey.length()-1)+")";
		String sql = sb.substring(0, sb.length() - 1);
		if(needMtri)sql+=","+mtriKey;
		sql = sql + (")ENGINE="+(isAdmin?"MyISAM ":"InnoDB ")+(autoId>=0?"AUTO_INCREMENT="+autoId+"":"")+" DEFAULT CHARSET="+(utf8mb4?"utf8mb4":"utf8"));
		ddlDao.createTable(sql, isAdmin);
	}

	/**
	 * 检查表中自增值是否正确
	 * @param resClass
	 * @param tbname
	 * @return
	 * @throws Exception
	 */
	private static void checkTableAutoIncrement(HashMap<String,Long> tabAutoMap,Map<String, Class<?>> resMap, boolean isAdmin) throws Exception{
		HashMap<String,Long> map = ddlDao.findAutoIncrement(isAdmin);
		if(map==null||map.isEmpty())return;
		Iterator<String> iter = resMap.keySet().iterator();
		while(iter.hasNext()){
			String tbname = iter.next();
			Long orval = map.get(tbname.toLowerCase());
			if(orval==null)continue;
			Long val = tabAutoMap.remove(tbname.toLowerCase());
			if(val!=null&&val>orval){
				ddlDao.alterAutoId(tbname,val,isAdmin);
				logger.error("table="+tbname+",autoid="+orval+" is rong,right autoid="+val);
			}
		}
	}
	
	
	private static void checkField(Map<String, Class<?>> resMap, boolean isAdmin) throws Exception {
		Iterator<Entry<String, Class<?>>> resIt = resMap.entrySet().iterator();
		while (resIt.hasNext()) {
			Entry<String, Class<?>> entry = resIt.next();
			String tbname = entry.getKey();
			boolean utf8mb4 = false;
			Class<?> resClass = entry.getValue();
			List<FieldStru> descTable = ddlDao.descTable(tbname, isAdmin);
			List<AlterColumn> alterTableList = getAlterTableList(resClass, tbname);
			if (descTable == null) {
				Long autoId = null;
				if (isAdmin){
					AdminSysTable sysTable = resClass.getAnnotation(AdminSysTable.class);
					autoId = SysTableAutoCache.getAutoId(sysTable.autoType());
					utf8mb4 = sysTable.utf8mb4();
				}else{
					SysTable sysTable = resClass.getAnnotation(SysTable.class);
					autoId = SysTableAutoCache.getAutoId(sysTable.autoType());
					utf8mb4 = sysTable.utf8mb4();
				}
				// 新表
				createTable(autoId==null?-1:autoId,tbname, utf8mb4, alterTableList, isAdmin);
			}else{
				Map<String, FieldStru> fieldMap = new HashMap<String, FieldStru>();
				for (FieldStru sqlStru : descTable) {
					fieldMap.put(sqlStru.getField(), sqlStru);
				}
				// 表字段和类字段对比
				for (AlterColumn alterColumn : alterTableList) {
					compareField(alterColumn, fieldMap, isAdmin);
				}
				if (fieldMap.size() > 0) {
					// 删除字段
					Iterator<Entry<String, FieldStru>> fieldIt = fieldMap.entrySet().iterator();
					while (fieldIt.hasNext()) {
						Entry<String, FieldStru> fieldEntry = fieldIt.next();
						String key = fieldEntry.getKey();
						ddlDao.dropColumn(tbname, key, isAdmin);
					}
				}
			}
		}
	}

	// 处理字段
	private static void compareField(AlterColumn col, Map<String, FieldStru> fieldMap, boolean isAdmin) throws Exception {
		FieldStru sqlStru = fieldMap.remove(col.getField());
		if(sqlStru==null)sqlStru = fieldMap.remove(col.getField().toLowerCase());
		if (sqlStru == null) {
			// 新增字段
			ddlDao.addColumn(col, isAdmin);
		} else {
			boolean typeSame = sqlStru.getType().equals(col.getType());
			boolean nullSame = sqlStru.getNull().equals(col.isNullCompare());
			boolean defSame = true;
			if(col.getKey()==null){
				if (StringUtils.isBlank(sqlStru.getDefault())) {
					if (!StringUtils.isBlank(col.getDefValEqauls())) {
						defSame = false;
					}
				}else{
					defSame = defSame && col.getDefValEqauls().equals(sqlStru.getDefault());
				}
			}
			if (typeSame && nullSame && defSame) {

			} else {
				ddlDao.modifyColumn(col, isAdmin);
			}
		}
	}

	private static void checkIndex(Map<String, Class<?>> resMap, boolean isAdmin) throws Exception {
		Iterator<Entry<String, Class<?>>> resIt = resMap.entrySet().iterator();
		while (resIt.hasNext()) {
			Entry<String, Class<?>> entry = resIt.next();
			String tbname = entry.getKey();
			Class<?> resClass = entry.getValue();
			List<KeyStru> showKeys = ddlDao.showKeys(tbname, isAdmin);
			List<AlterColumn> alterTableList = getAlterTableList(resClass, tbname);
			if (showKeys != null) {
				Map<String, KeyStru> keysMap = new HashMap<String, KeyStru>();
				for (KeyStru keyStru : showKeys) {
					keysMap.put(keyStru.getColumn_name(), keyStru);
				}
				for (AlterColumn alterColumn : alterTableList) {
					compareIndex(alterColumn, keysMap, isAdmin);
				}
				if (keysMap.size() > 0) {
					// 删除索引
					Iterator<Entry<String, KeyStru>> keyIt = keysMap.entrySet().iterator();
					while (keyIt.hasNext()) {
						Entry<String, KeyStru> keyEntry = keyIt.next();
						String key_name = keyEntry.getValue().getKey_name();
						if(!tbname.contains("log_")){
							ddlDao.dropIndex(tbname, key_name, isAdmin);
						}
					}
				}
			}
		}
	}

	// 处理索引
	private static void compareIndex(AlterColumn col, Map<String, KeyStru> keysMap, boolean isAdmin) throws Exception {
		IndexEnum key = col.getKey();
		if (key != null) {
			// 有key
			KeyStru keyStru = keysMap.get(col.getField());
			if (keyStru == null) {
				// 新增key
				String addKey = getAddIndex(key, col);
				addKey = col.getTbname() + " " + addKey;
				try {
					ddlDao.modifyIndex(addKey, isAdmin);
				} catch (Exception e) {
					logger.error("",e);
				}
			} else {
				// 对比
				if ((key == IndexEnum.NORMAL && keyStru.getNon_unique() == 0) || key == IndexEnum.UNIQUE && keyStru.getNon_unique() == 1) {
					String addKey = getAddIndex(key, col);
					addKey = col.getTbname() + " DROP INDEX " + keyStru.getKey_name() + "," + addKey;
					try {
						ddlDao.modifyIndex(addKey, isAdmin);
					} catch (Exception e) {
						logger.error("",e);
					}
				}
				keysMap.remove(col.getField());
			}
		}
	}
	private static String getAddIndex(IndexEnum key, AlterColumn col) {
		StringBuilder sb = new StringBuilder();
		sb.append("ADD ");
		if (key == IndexEnum.UNIQUE) {
			// 暂时不支持primary key
			sb.append("UNIQUE ");
		}
		sb.append("INDEX ");
		sb.append(col.getKeyName()).append(BL).append("(").append(col.getField()).append(")");
		return sb.toString();
	}
	
	private static List<AlterColumn> getAlterTableList(Class<?> resClass, String tbname) throws Exception {
		List<AlterColumn> list = new ArrayList<AlterColumn>();
		List<Field> declaredFields = ClassUtil.getAllField(resClass);
		for (Field field : declaredFields) {
			Annotation[] annotations = field.getAnnotations();
			String fieldName = null;
			String fieldType = "";
			int len = 0;
			int dec = 0;//精度
			boolean isNull = false;
			String defVal = null;
			String comment = "";
			IndexEnum key = null;
			String keyName = null;
			for (Annotation annotation : annotations) {
				if (annotation instanceof Index) {
					Index index = (Index) annotation;
					String indexName = index.name();
					if ("".equals(indexName)) {
						keyName = "i_" + field.getName();
					} else {
						keyName = indexName;
					}
					key = index.key();
				} else {
					if (annotation instanceof ColumnBigInt) {
						// bigint
						ColumnBigInt bigint = (ColumnBigInt) annotation;
						fieldName = bigint.field();
						if ("".equals(fieldName)) {
							fieldName = field.getName();
						}
						fieldType = "bigint";
						len = bigint.len();
						defVal = bigint.defVal()+"";
						comment = bigint.comment();
						isNull = bigint.isNull();
					} else if (annotation instanceof ColumnInt) {
						// int
						ColumnInt colInt = (ColumnInt) annotation;
						fieldName = colInt.field();
						if ("".equals(fieldName)) {
							fieldName = field.getName();
						}
						fieldType = "int";
						len = colInt.len();
						defVal = colInt.defVal()+"";
						comment = colInt.comment();
						isNull = colInt.isNull();
					} else if (annotation instanceof ColumnTinyInt) {
						// tinyint
						ColumnTinyInt tinyInt = (ColumnTinyInt) annotation;
						fieldName = tinyInt.field();
						if ("".equals(fieldName)) {
							fieldName = field.getName();
						}
						fieldType = "tinyint";
						len = tinyInt.len();
						defVal = tinyInt.defVal()+"";
						comment = tinyInt.comment();
						isNull = tinyInt.isNull();
					} else if (annotation instanceof ColumnSmallInt) {
						// smallint
						ColumnSmallInt tinyInt = (ColumnSmallInt) annotation;
						fieldName = tinyInt.field();
						if ("".equals(fieldName)) {
							fieldName = field.getName();
						}
						fieldType = "smallint";
						len = tinyInt.len();
						defVal = tinyInt.defVal()+"";
						comment = tinyInt.comment();
						isNull = tinyInt.isNull();
					} else if (annotation instanceof ColumnVar) {
						// varchar
						ColumnVar varchar = (ColumnVar) annotation;
						fieldName = varchar.field();
						if ("".equals(fieldName)) {
							fieldName = field.getName();
						}
						fieldType = "varchar";
						len = varchar.len();
						defVal = varchar.defVal();
						comment = varchar.comment();
						isNull = varchar.isNull();
					} else if (annotation instanceof ColumnText) {
						// text
						ColumnText colText = (ColumnText) annotation;
						fieldName = colText.field();
						if ("".equals(fieldName)) {
							fieldName = field.getName();
						}
						fieldType = "text";
						comment = colText.comment();
						defVal = "";
						isNull = colText.isNull();
					}else if (annotation instanceof ColumnLongText) {
						// longtext
						ColumnLongText colText = (ColumnLongText) annotation;
						fieldName = colText.field();
						if ("".equals(fieldName)) {
							fieldName = field.getName();
						}
						fieldType = "longtext";
						comment = colText.comment();
						defVal = "";
						isNull = colText.isNull();
					}else if(annotation instanceof ColumnFloat){
						//float
						ColumnFloat cfloat = (ColumnFloat) annotation;
						fieldName = cfloat.field();
						if ("".equals(fieldName)) {
							fieldName = field.getName();
						}
						fieldType = "float";
						len = cfloat.len();
						defVal = cfloat.defVal()+"";
						comment = cfloat.comment();
						isNull = cfloat.isNull();
						dec = cfloat.dec();
					}
				}
			}
			if (fieldName != null) {
				//浮点型特别处理
				if(StringUtils.equals("float",fieldType)){
					fieldType=fieldType + "(" + len + ","+dec+")";
				}else if(StringUtils.equals("longtext",fieldType)){
					//longtext 不加()
				}else if(!StringUtils.equals("text",fieldType)){
					fieldType=fieldType + "(" + len + ")";
				}
				AlterColumn column = new AlterColumn(tbname,fieldName,fieldType, isNull,defVal,comment, key, keyName);
				list.add(column);
			}
		}
		return list;
	}
}
