package com.pub.map;

/**
 * 使用二维数组实现Map集合
 * @author JOINT
 * @param <V>
 * @param <K>
 *
 */
public class ArrImplMap<E, V, K> {
	
	// 下标
	private int index;
	// 二维数组
	private E[][] map = null;
	// 默认初始化
	@SuppressWarnings("unchecked")
	public ArrImplMap() {
		if(map == null ) {
			map = (E[][]) new Object[0][0];
		}
	}
	/**
	 * 存储数据 （如果Key值重复，则会被覆盖掉）
	 * @param key
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	public void put(K key,V  value) {
		// 不存在就增加一条记录
		if(!isRepeat(map,key,value)) {
			// 容量是否足够
			map = getMapSize(map,index + 1);
			map[index][0] = (E) key;
			map[index][1] = (E) value;
		}
	}
	
	/**
	 * 获取key 的值
	 * @param key
	 * @return
	 */
	public  E get(E key) {
		E value = null;
		for (int i = 0; i < map.length; i++) {
			if (key.equals(map[i][0])) {
				value = map[i][1];
				break;
			}
		}
		return value;
	}
	
	/**
	 * 扩充空间：增加二维数组的存储空间，数据不变
	 * @param map2
	 * @param i
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private E[][] getMapSize(E[][] map2, int i) {
		if(map2 == null) {
			map = (E[][]) new Object[1][2];
		}
		Object [][] temp  = new Object[i][2];
		System.arraycopy(map2, 0, temp, 0, map2.length);
		map2 = null;
		return (E[][]) temp;
	}
	/** 判断集合key 是否存在
	 * 如果存在，替换 key的value  返回true
	 * 如果不存在就返回false
	 * @param map2
	 * @param key
	 * @param value
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	private boolean isRepeat(E[][] map2, K key, V value) {
		boolean flg =false;
		for (int i = 0; i < map2.length; i++) {
			// 查看是否存在key
			if (key.equals(map2[i][0])) {
				// 替换值
				map2[i][1] = (E) value;
				flg = true;
				break;
			}
		}
		return flg;
	}
	/**
	* @Description:清除map内数据
	*/
	 @SuppressWarnings("unchecked")
	public void clear(){
		  index = 0;
		  map = (E[][]) new Object[0][0];
	 }
	 
	 /*判断Map是否为空*/
	 public boolean isEmpty(){
		 return map.length == 0;
	 }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		ArrImplMap map = new ArrImplMap();
		
		map.put("this", 123456);
		map.put("this", 22212456);
		System.out.println(map.get("this"));
		
		map.clear();
		
		System.out.println(map.isEmpty());
	}
}
