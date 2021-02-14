package cn.until;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 关于日期的转化函数
 * 
 * @author Administrator
 *
 */
public class DateFormat {
	/**
	 * V 获得当前时间 yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	/**
	 * V 获得当前日期 yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	/**
	 * V比较时间
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public static boolean compareDate(String date1, String date2) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateA = dateFormat.parse(date1);
		Date dateB = dateFormat.parse(date2);
		return dateA.getTime() > dateB.getTime() ? true : false;
	}

	/**
	 * 将时间戳转化为时间yyyy-MM-dd HH:mm:ss
	 * 
	 * @param str 时间戳
	 * @return
	 */
	public static Date toDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long time = new Long(str);
		String d = format.format(time);
		Date date = null;
		try {
			date = format.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	// 转化成String标准时间
	public static String toStringDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long time = new Long(str);

		return format.format(time);
	}
	//date转化成String
	public static String dateToString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return format.format(date);
	}
	public static Date dateToDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String d = format.format(date);
		Date date1 = null;
		try {
			date1 = format.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1;
	}
	/**
	 * 将时间戳转化为时间yyyy-MM-dd HH:mm:ss
	 * 
	 * @param str 时间戳
	 * @return
	 */
	public static Date toDate(Long str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long time = new Long(str);
		String d = format.format(time);
		Date date = null;
		try {
			date = format.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
