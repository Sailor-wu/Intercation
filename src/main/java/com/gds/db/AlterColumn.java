package com.gds.db;


import org.apache.commons.lang3.StringUtils;

public class AlterColumn {
	private String tbname;
	private String field;
	private String type;
	private boolean isNull;
	private String defVal;
	private String comment;
	private IndexEnum key;
	private String keyName;
	private long autoId;
	public String getKeyName() {
		return keyName;
	}
	public IndexEnum getKey() {
		return key;
	}
	public String getTbname() {
		return tbname;
	}
	public void setTbname(String tbname) {
		this.tbname = tbname;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIsNull() {
		return isNull==true?"NULL":"NOT NULL";
	}
	public String isNullCompare(){
		return isNull==true?"YES":"NO";
	}
	public void setNull(boolean isNull) {
		this.isNull = isNull;
	}
	public String getDefVal() {
		if(type.indexOf("text")!=-1||type.indexOf("varchar")!=-1){
			if(StringUtils.isBlank(defVal)){
				return "";
			}else{
				return "DEFAULT '"+defVal+"'";
			}
		}else{
			return "DEFAULT "+defVal+"";
		}
	}
	public String getDefValEqauls(){
		return defVal;
	}
	public void setDefVal(String defVal) {
		this.defVal = defVal;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public long getAutoId() {
		return autoId;
	}
	public void setAutoId(long autoId) {
		this.autoId = autoId;
	}
	public AlterColumn(String tbname, String field, String type, boolean isNull, String defVal, String comment,IndexEnum key,String keyName) {
		super();
		this.tbname = tbname;
		this.field = field;
		this.type = type;
		this.isNull = isNull;
		this.defVal = defVal;
		this.comment = comment;
		this.key = key;
		this.keyName = keyName;
	}
	
	
}
