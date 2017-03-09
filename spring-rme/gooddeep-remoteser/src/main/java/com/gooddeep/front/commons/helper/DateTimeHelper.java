package com.gooddeep.front.commons.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间日期帮助类
 * @author lhy
 *
 */
public class DateTimeHelper {
	
	/**
	 * YYYY-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String dateToYMdHms(Date date)
	{
		SimpleDateFormat myFmt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		String dateStr = myFmt.format(date);
		return dateStr;
	}
	/**
	 * YYYY-MM-dd HH:mm
	 * @param date
	 * @return
	 */
	public static String dateToYMdHm(Date date)
	{
		SimpleDateFormat myFmt = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		String dateStr = myFmt.format(date);
		return dateStr;
	}
	/**
	 * YYYY-MM-dd HH
	 * @param date
	 * @return
	 */
	public static String dateToYMdH(Date date)
	{
		SimpleDateFormat myFmt = new SimpleDateFormat("YYYY-MM-dd HH");
		String dateStr = myFmt.format(date);
		return dateStr;
	}
	
	/**
	 * YYYY-MM-dd
	 * @param date
	 * @return
	 */
	public static String dateToYMd(Date date)
	{
		SimpleDateFormat myFmt = new SimpleDateFormat("YYYY-MM-dd");
		String dateStr = myFmt.format(date);
		return dateStr;
	}
	/**
	 * YYYY-MM
	 * @param date
	 * @return
	 */
	public static String dateToYM(Date date)
	{
		SimpleDateFormat myFmt = new SimpleDateFormat("YYYY-MM");
		String dateStr = myFmt.format(date);
		return dateStr;
	}
	/**
	 * YYYY
	 * @param date
	 * @return
	 */
	public static String dateToYYYY(Date date)
	{
		SimpleDateFormat myFmt = new SimpleDateFormat("YYYY");
		String dateStr = myFmt.format(date);
		return dateStr;
	}
	
	/**
	 * 获得上个月的第一天日期
	 * yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String getLastMonthFirstDay(Date date){
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH,cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        String day=sdf.format(cal.getTime());
        return day;
	}
	/**
	 * 得到上个月月份
	 * yyyy-MM
	 * @param date
	 * @return
	 */
	public static String getLastMonth(Date date){
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.MONTH, -1);
  //  cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    String day=sdf.format(cal.getTime());
    return day;
	}
	
	
	/**
	 * 得到上一年 年份
	 * @param date
	 * @return
	 */
	public static String getLastYear(Date date){
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  cal.add(Calendar.YEAR, -1);
		//  cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		  String day=sdf.format(cal.getTime());
		  return day;
	}
	
	
	/**
	 * 获得上月最后一天的日期
	 * yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String getLastMonthEndDay(Date date){
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(Calendar.MONTH, -1);
      cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
      String day=sdf.format(cal.getTime());
      return day;
	}
	
	/**
	 * 获得上一年一月日期
	 * yyyy-MM
	 * @param date
	 * @return
	 */
	public static String getLastYearFirstMonth(Date date){
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(Calendar.YEAR, -1);
      cal.set(Calendar.DAY_OF_YEAR,cal.getActualMinimum(Calendar.DAY_OF_YEAR));
      String month=sdf.format(cal.getTime());
      return month;
	}
	
	/**
	 * 获得上一年12月日期
	 * yyyy-MM
	 * @param date
	 * @return
	 */
	public static String getLastYearEndMonth(Date date){
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.YEAR, -1);
    cal.set(Calendar.DAY_OF_YEAR,cal.getActualMaximum(Calendar.DAY_OF_YEAR));
    String month=sdf.format(cal.getTime());
    return month;
	}
	
	
	public static void main(String[] args) {
		System.out.println(getLastMonthEndDay(new Date()));
		
	}
	
}
