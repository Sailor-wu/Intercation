package com.gds.db.annotation;

import com.gds.db.AutoType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 后台流水表
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminSysTable {
	String tableName() default "";//默认取类字段名
	String comment() default "";//注释
	AutoType autoType() default AutoType.BLANK;//默认为不自增
	boolean utf8mb4() default true;//默认utf8mb4
}
