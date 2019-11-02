package com.gds.db.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * smallint列
 * @author yxh
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnSmallInt {
	String field() default "";//默认取类字段名
	int len() default 2;//列长度
	boolean isNull() default false;//是否为null,默认不允许
	int defVal() default 0;//默认值,默认为0
	String comment();//注释
}