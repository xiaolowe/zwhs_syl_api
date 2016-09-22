package cn.org.citycloud.zwhs.syl.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理
 * @author Allen
 *
 */
public class DateUtil {
	
	public static Date convertMinDate(Date date)throws Exception{
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str1 = df1.format(date);
		String str2 = str1+" 00:00:00";
		return df2.parse(str2);
	}
	
	public static Date convertMaxDate(Date date)throws Exception{
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str1 = df1.format(date);
		String str2 = str1+" 23:59:59";
		return df2.parse(str2);
	}
	
}
