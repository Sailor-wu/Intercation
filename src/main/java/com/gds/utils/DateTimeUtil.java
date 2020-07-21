package com.gds.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间日期工具类
 * @author 哈皮
 *
 */
public class DateTimeUtil {
	public static final SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");
	public static final SimpleDateFormat mdhm = new SimpleDateFormat("MM-dd HH:mm");
	public static final SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
	public static final SimpleDateFormat ymdhm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static final SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat ymdChinese = new SimpleDateFormat("yyyy年MM月dd日");
	public static final SimpleDateFormat ymdSlash = new SimpleDateFormat("yyyy/MM/dd");
	/**
	 * 一天的时间
	 */
	public static final long ONEDAY = 3600*24*1000;
	public static final long ONEHOUR = 3600*1000;
	public static final int ONE_HOUR_INT = 3600;
	public static final int ONE_DAY_INT = 3600*24;
	public static final int ONE_SECOND = 1;//1秒
	public static final int ONE_MINUTE = 60;//1分钟
	public static final int FIVE_MINUTE = 60*5;//5分钟
	
	/**
	 * 获取当前时间
	 * @name getCurrentTime
	 * @return 当前以int类型返回的数值
	 */
	public static int getCurrentTime(){
		return (int) (System.currentTimeMillis()/1000);
	}
	
	/**
	 * 计算两个时间点间隔的正点数量
	 * @param start
	 * @param end
	 * @return
	 */
	public static int cacBetweenHour(int start,int end){
		if(start>=end)return 0;
		Calendar calendars = Calendar.getInstance();
		calendars.setTime(new Date(start*1000));
		Calendar calendare = Calendar.getInstance();
		calendare.setTime(new Date(end*1000));
		int endHour = calendare.get(Calendar.HOUR_OF_DAY);
		int startHour = calendars.get(Calendar.HOUR_OF_DAY);
		return (end-start)/60+(endHour-startHour);
	}

	/**
	 * 比较两个时间相差的天数
	 * @param start 开始时间戳（秒）
	 * @param end 结束时间戳（秒）
	 * @return 
	 */
	public static int getDayBetween(int start, int end){
		if(end<=start)return 0;
		int l = end-start;
		return l / (24 * 60 * 60 ); 
	}
	
	/**
	 * 获取今天零点时间戳（秒）
	 * @return 
	 */
	public static int getTodayZeroTimeInt(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return (int) (calendar.getTimeInMillis()/1000);
	}

	/**
     * 获取某一天的0点
     * @param d
     * @return
     */
    public static int getZeroTimeInt(Date date) {  
    	Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DATE,calendar.get(Calendar.DAY_OF_MONTH));
        date = new Date(calendar.getTimeInMillis());  
        return (int)(date.getTime()/1000); 
   } 
    
    /**
	 * 获取当前时间周一0点0分时间
	 * @return
	 */
	public static int getMondayZeroTime(){
		Calendar dataCal = Calendar.getInstance();
		dataCal.setFirstDayOfWeek(Calendar.MONDAY);
		dataCal.set(Calendar.DAY_OF_WEEK, 2);
		dataCal.set(Calendar.HOUR_OF_DAY, 0);
		dataCal.set(Calendar.MINUTE, 0);
		dataCal.set(Calendar.SECOND, 0);
		return (int) (dataCal.getTimeInMillis()/1000);
	}
	
	/**
	 * 获取指定时间当天零点的时间戳
	 * @param time 秒
	 * @return 秒
	 */
	public static int getDayZeroTime(long time){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return (int)(calendar.getTimeInMillis()/1000);
	}
	
	/**
	  * 返回今天是周几
	  * @return 周一到周日分别是 1~7
	  */
	 public static int getWeek() {
		  // 再转换为时间
		 Calendar c = Calendar.getInstance();
		 int week = c.get(Calendar.DAY_OF_WEEK);
		 if(week == 1){
			 return 7;
		 }else{
			 return week - 1;
		 }
	 }
	 
	 /**
	  * 获取现在是几点
	  * @return
	  */
	 public static int getHour(){
		 Calendar c = Calendar.getInstance();
		 return c.get(Calendar.HOUR_OF_DAY);
	 }
	 /**
	  * 根据传入的："HH:mm:ss"格式的字符时间判断当前时间是否小于传入的时间
	  * @param time  格式："HH:mm:ss"
	  * @return boolean 大于 false 不大于
	  */
	 public static boolean isLessTime(String time){
		 Date data1 = new Date();
		String ymd = formatYMD(data1);
		String ymdhms = ymd+" "+time;
		Date date2 = parseYMDHMS(ymdhms);
		return data1.getTime() < date2.getTime();
	 }
	 
	 /**
	  * 根据传入的："HH:mm:ss"格式的字符时间判断当前时间是否大于等于传入的时间
	  * @param time  格式："HH:mm:ss"
	  * @return boolean 大于 false 不大于
	  */
	 public static boolean isLargeOrEqualTime(String time){
		Date data1 = new Date();
		String ymd = formatYMD(data1);
		String ymdhms = ymd+" "+time;
		Date date2 = parseYMDHMS(ymdhms);
		return data1.getTime() >= date2.getTime();
	 }
	 
	 
	 /**
	  * 判断当前时间是否在给定的时间段内
	  * @param start 开始时间 "HH:mm:ss"
	  * @param end 结束时间 "HH:mm:ss"
	  * @return
	  */
	public static boolean isBetweenTimes(String start, String end) {
		return !isLargeOrEqualTime(end)&&isLargeOrEqualTime(start);
	}
	
	/**
	 * 判断当前时间是否在给定的时间段内
	 * @param start 开始时间 "HH:mm"
	 * @param end 结束时间 "HH:mm"
	 * @return
	 */
	public static boolean isBetweenTimes2(String start, String end) {
		return !isLargeOrEqualTime(end+":00")&&isLargeOrEqualTime(start+":00");
	}
	
	/**
	 * 判断当前时间是否在指定的时间点范围内
	 * @param startHour
	 * @param startMin
	 * @param endHour
	 * @param endMin
	 * @return
	 */
	public static boolean isBetweenTimes(int startHour, int startMin, int endHour, int endMin){
		return isBetweenTimes(startHour, startMin, 0, endHour, endMin, 0);
	}
	
	/**
	 * 判断当前时间是否在指定的时间点范围内
	 * @param startHour
	 * @param startMin
	 * @param startSec
	 * @param endHour
	 * @param endMin
	 * @param endSec
	 * @return
	 */
	public static boolean isBetweenTimes(int startHour, int startMin, int startSec, int endHour, int endMin, int endSec) {
		int startTime = getTime(startHour, startMin, startSec);
		int endTime = getTime(endHour, endMin, endSec);
		int currTime = getCurrentTime();
		return currTime >= startTime && currTime < endTime;
	}
	
	/**
	 * 否是同一天
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static boolean isSameDay(int t1, int t2){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis((long)t1*1000);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.setTimeInMillis((long)t2*1000);
		int year2 = calendar.get(Calendar.YEAR);
		int month2 = calendar.get(Calendar.MONTH);
		int day2 = calendar.get(Calendar.DAY_OF_MONTH);
		if(year==year2){
			if(month==month2){
				if(day==day2){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 以凌晨4点来计算是否是同一天
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static boolean isSameDay4(int time1, int time2){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis((long)(time1-14400)*1000);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		calendar.setTimeInMillis((long)(time2-14400)*1000);
		int year2 = calendar.get(Calendar.YEAR);
		int month2 = calendar.get(Calendar.MONTH);
		int day2 = calendar.get(Calendar.DAY_OF_MONTH);
		
		if(year==year2){
			if(month==month2){
				if(day==day2){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 获取传入时间中的（1年，2月，3日，4时，5分，6秒）其中一个数值
	 * @param type 1, 2, 3, 4, 5, 6
	 * @param time
	 */
	public static int getSingleValueOfTime(int time, int type){
		int value = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date((long)time*1000));
		switch (type) {
		case 1:
			value = calendar.get(Calendar.YEAR);
			break;

		case 2:
			value = calendar.get(Calendar.MONTH);
			break;
			
		case 3:
			value = calendar.get(Calendar.DATE);
			break;

		case 4:
			value = calendar.get(Calendar.HOUR_OF_DAY);
			break;

		case 5:
			value = calendar.get(Calendar.MINUTE);
			break;
			
		case 6:
			value = calendar.get(Calendar.SECOND);
			break;

		default:
			break;
		}
		return value;
	}
	
	/**
	 * 获取两个时间是否为同一个小时
	 * @param time1
	 * @param time2
	 * @return true是一个小时
	 */
	public static boolean isSameHour(int time1,int time2){
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTimeInMillis(time1*1000l);
		c2.setTimeInMillis(time2*1000l);
		return c1.get(Calendar.HOUR_OF_DAY)==c2.get(Calendar.HOUR_OF_DAY);  
		
	}
	
	// 获取当月第一天  
	public static String getFirstDayOfMonth() {  
	    Calendar lastDate = Calendar.getInstance();  
	    lastDate.set(Calendar.DATE, 1);// 设为当前月的1号  
	    return formatYMD(lastDate.getTime());
	}
	
	// 获得当前日期与本周日相差的天数  
	private static int getMondayPlus() {  
	    Calendar cd = Calendar.getInstance();  
	    // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......  
	    int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1  
	    if (dayOfWeek == 0) {  
	        return -6;  
	    }  
	    if (dayOfWeek == 1) {  
	        return 0;  
	    } else {  
	        return 1 - dayOfWeek;  
	   }  
	}

	// 根据当前时间获得下周星期一的日期  
	public static String getNextMonday() {  
	    int mondayPlus = getMondayPlus();  
	    GregorianCalendar currentDate = new GregorianCalendar();  
	    currentDate.add(GregorianCalendar.DATE, mondayPlus + 7);  
	    Date monday = currentDate.getTime();  
	    DateFormat df = DateFormat.getDateInstance();  
	    String preMonday = df.format(monday);  
	    return preMonday;  
	} 
	
	/** 
	 * 取得当月天数 
	 * */  
	public static int getCurrMonthDays(){  
	    Calendar a = Calendar.getInstance();  
	    a.set(Calendar.DATE, 1);//把日期设置为当月第一天  
	    a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
	    return a.get(Calendar.DATE);  
	}  
	
	/**
	 * 判断俩个时间是不是同一周 传入时间为秒
	 * @return
	 */
	public static boolean isSameWeek(int t1, int t2){
		  Calendar cal1 = Calendar.getInstance();
		  Calendar cal2 = Calendar.getInstance();
		  cal1.setFirstDayOfWeek(Calendar.MONDAY);//西方周日为一周的第一天，咱得将周一设为一周第一天
		  cal2.setFirstDayOfWeek(Calendar.MONDAY);
		  cal1.setTimeInMillis((long)t1*1000);
		  cal2.setTimeInMillis((long)t2*1000);
		  int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		  if(subYear == 0){
			  // subYear==0,说明是同一年
			  if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				  return true;
		  }else if(subYear == 1 && cal2.get(Calendar.MONTH) == 11){
			  //subYear==1,说明cal比cal2大一年;java的一月用"0"标识，那么12月用"11"
			  if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
		   			return true;
		  }else if (subYear == -1 && cal1.get(Calendar.MONTH) == 11){
			  //subYear==-1,说明cal比cal2小一年
			  if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				  return true;
		  }
		  return false;
	}
	
	/**
	 * 判断两个时间戳是否是同一周，以周一4点作为分界
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static boolean isSameWeek4(int t1, int t2){
		return isSameWeek(t1-14400, t2-14400);
	}
	
	/**
	 * 获取本周某天的零点 秒
	 * @return
	 */
	public static int getDayOfWeekZeroTime(int dayOfWeek) {  
		Calendar dataCal = Calendar.getInstance();
		dataCal.setFirstDayOfWeek(Calendar.MONDAY);
		dataCal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		dataCal.set(Calendar.HOUR_OF_DAY, 0);
		dataCal.set(Calendar.MINUTE, 0);
		dataCal.set(Calendar.SECOND, 0);
		return (int) (dataCal.getTimeInMillis()/1000);
   } 

	/**
	 * 获取本周某天的某个时间
	 * @return
	 */
	public static int getDayOfWeekTime(int dayOfWeek,int hour,int min,int sec) {  
    	Calendar dataCal = Calendar.getInstance();
		dataCal.setFirstDayOfWeek(Calendar.MONDAY);
		dataCal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		dataCal.set(Calendar.HOUR_OF_DAY, hour);
		dataCal.set(Calendar.MINUTE, min);
		dataCal.set(Calendar.SECOND, sec);
		return (int) (dataCal.getTimeInMillis()/1000);
	}
	
	/**
	 * 获取今天某个时间点的时间戳
	 * @param hour 小时
	 * @param min 分钟
	 * @param sec 秒
	 * @return
	 */
	public static int getTime(int hour, int min, int sec) {  
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, sec);
		calendar.set(Calendar.MILLISECOND, 0);
		return (int) (calendar.getTimeInMillis()/1000);
	} 
	
	/**
	 * 修改系统时间
	 * @param datetimestr
	 * @return
	 */
	public static boolean updateSysTime(String datetimestr){
		if(datetimestr.length() != 19){
			return false;
		}
		String arr[] = datetimestr.split(" ");
		try {
			Runtime.getRuntime().exec("cmd /c date "+arr[0]);
			Runtime.getRuntime().exec("cmd /c time "+arr[1]);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * 判断传入的两个时间戳是否是同一个月
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static boolean isSameMonth(int t1, int t2){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis((long)t1*1000);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		calendar.setTimeInMillis((long)t2*1000);
		int year2 = calendar.get(Calendar.YEAR);
		int month2 = calendar.get(Calendar.MONTH);
		if(year==year2 && month==month2){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断传入的两个时间戳是否是同一个月（以凌晨4点为界限）
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static boolean isSameMonth4(int t1, int t2){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis((long)(t1-14400)*1000);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		calendar.setTimeInMillis((long)(t2-14400)*1000);
		int year2 = calendar.get(Calendar.YEAR);
		int month2 = calendar.get(Calendar.MONTH);
		if(year==year2 && month==month2){
			return true;
		}
		return false;
	}
	
	/**
	 * 将字符串形式的日期时间转换成Date
	 * @param format
	 * @param dateStr
	 * @return
	 */
	public static Date parse(SimpleDateFormat format, String dateStr) {
		try {
			Date d = format.parse(dateStr);
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			int year = c.get(Calendar.YEAR);
			if (year >= 1000 && year <= 9999) {
				return d;
			} else {
				return null;
			}
		} catch (ParseException ex) {
			return null;
		}
	}
	
	/**
	 * 将格式化的时间转成date
	 * @param dateStr yyyy-MM-dd
	 * @return
	 */
	public static Date parseYMD(String dateStr) {
		return parse(ymd, dateStr);
	}

	public static long getSystemDiffDataTime(long startTime) {
		return System.currentTimeMillis()-startTime;
	}
	public static Date parseYMDHMS(String dateStr) {
		return parse(ymdhms, dateStr);
	}
	
	public static Date parseHMS(String dateStr) {
		return parse(hms, dateStr);
	}
	
	/**
	 * 将date格式化成"yyyy-MM-dd"的形式
	 * @param date
	 * @return
	 */
	public static String formatYMD(Date date) {
		return ymd.format(date);
	}

	public static String formatHMS(Date date) {
		return hms.format(date);
	}

	public static String formatMDHM(Date date) {
		return mdhm.format(date);
	}

	public static String formatHM(Date date) {
		return hm.format(date);
	}

	public static String formatYMDHM(Date date) {
		return ymdhm.format(date);
	}

	public static String formatYMDHMS(Date date) {
		return ymdhms.format(date);
	}

	public static String formatYMDChinese(Date date) {
		return ymdChinese.format(date);
	}

	public static String formatYMDSlash(Date date) {
		return ymdSlash.format(date);
	}
	
	public static void main(String[] args) {
		int t1=1558900800;//今天
		int t2=1559491200;
		System.out.println(isSameWeek4(t1, t2));
		System.out.println(getTime(10, 10, 0));
	}

}