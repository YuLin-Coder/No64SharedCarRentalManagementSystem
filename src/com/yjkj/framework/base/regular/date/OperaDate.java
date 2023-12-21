package com.yjkj.framework.base.regular.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OperaDate {

	private OperaDate() {};
	
	//增加时间
			public static String addDate(int num,String today) {
				Calendar c = Calendar.getInstance();  
				Date date = null;
				try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(today);
				}catch (ParseException e) {
					throw new RuntimeException("增加日期失败,原因为:"+e.getMessage());
				}
				c.setTime(date);  
		        int day = c.get(Calendar.DATE);  
		        c.set(Calendar.DATE, day + num);  
		        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());  
		        return dayAfter;  // 返回当前时间，格式，2017-03-29 10:05:37 （年、月、日、时、分、秒；24小时制）
			}
		
		//增加时间
		public static String addDateTime(int num,String today) {
			Calendar c = Calendar.getInstance();  
			Date date = null;
			try {
			date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(today);
			}catch (ParseException e) {
				throw new RuntimeException("增加日期失败,原因为");
			}
			c.setTime(date);  
	        int day = c.get(Calendar.DATE);  
	        c.set(Calendar.DATE, day + num);  
	        String dayAfter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(c.getTime());  
	        return dayAfter;  // 返回当前时间，格式，2017-03-29 10:05:37 （年、月、日、时、分、秒；24小时制）
		}
		
		  public static int daysBetween(String smdate,String bdate) throws ParseException{  
		        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		        Calendar cal = Calendar.getInstance();    
		        cal.setTime(sdf.parse(smdate));    
		        long time1 = cal.getTimeInMillis();                 
		        cal.setTime(sdf.parse(bdate));    
		        long time2 = cal.getTimeInMillis();         
		        long between_days=(time2-time1)/(1000*3600*24);  
		            
		       return Integer.parseInt(String.valueOf(between_days));     
		    }  
}
