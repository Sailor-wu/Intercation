package com.gds.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类工具类
 *
 */
public class ClassUtil {
	
	 /**
     * 获取类clazz的所有Field，包括其父类的Field，如果重名，以子类Field为准。
     * @param clazz
     * @return Field数组
     */
    public static List<Field> getAllField(Class<?> clazz) {
        ArrayList<Field> fieldList = new ArrayList<Field>();
        Field[] dFields = clazz.getDeclaredFields();
        if (null != dFields && dFields.length > 0) {
            fieldList.addAll(Arrays.asList(dFields));
        }
        Class<?> superClass = clazz.getSuperclass();
        if (superClass != Object.class) {
            List<Field> superFields = getAllField(superClass);
            if (null != superFields && superFields.size()> 0) {
                for(Field field:superFields){
                    if(!isContain(fieldList, field)){
                        fieldList.add(field);
                    }
                }
            }
        }
        return fieldList;
    }
    

	@SuppressWarnings("rawtypes")
	public static void printObj(Object o) {
		// 获取参数类
		Class cls = o.getClass();
		// 将参数类转换为对应属性数量的Field类型数组（即该类有多少个属性字段 N 转换后的数组长度即为 N）
		Field[] fields = cls.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			f.setAccessible(true);
			try {
				// f.getName()得到对应字段的属性名，f.get(o)得到对应字段属性值,f.getGenericType()得到对应字段的类型
				System.out.println(f.getName() + "=" + f.get(o));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

    /**检测Field List中是否已经包含了目标field
     * @param fieldList
     * @param field 带检测field
     * @return
     */
    private static boolean isContain(ArrayList<Field> fieldList,Field field){
        for(Field temp:fieldList){
            if(temp.getName().equals(field.getName())){
                return true;
            }
        }
        return false;
    }
}
