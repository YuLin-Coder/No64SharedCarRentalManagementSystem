package com.yjkj.framework.base.regular.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {

	private FormatDate() {};
	
	public static String formatDateTime(String date) {
		Date d = null;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date);
		} catch (ParseException e) {
			throw new RuntimeException("格式化日期失败,原因为:"+e.getMessage());
		}
		String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(d);
		return time;// 返回当前时间，格式，2017-03-29 10:05:37 （年、月、日、时、分、秒；24小时制）
	}
	
	public static String formatDate(String date) {
		Date d = null;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			throw new RuntimeException("格式化日期失败,原因为:"+e.getMessage());
		}
		String time = new SimpleDateFormat("yyyy-MM-dd").format(d);
		return time;// 返回当前时间，格式，2017-03-29（只要年月日）
	}
	
}
