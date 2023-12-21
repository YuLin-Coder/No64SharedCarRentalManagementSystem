package com.yjkj.framework.base.regular.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreatDate {
	
	private CreatDate(){};

	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String time = dateFormat.format(date);
		return time;// 返回当前时间，格式，2017-03-29（只要年月日）
	}
	
	public static String getDateTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = dateFormat.format(date);
		return time;// 返回当前时间，格式，2017-03-29 10:05:37 （年、月、日、时、分、秒；24小时制）
	}
	
}
