package com.yanxiaobo.shucheng.v1.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yy/MM",Locale.CHINA);
	private static Date date = new Date();
	public static String getFormatTime(long time){
		date.setTime(time);
		return sdf.format(date);		
	}
}
