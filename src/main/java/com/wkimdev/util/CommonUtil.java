package com.wkimdev.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 
 * CommonUtil
 * 
 * created by wkimdev
 * 
 */
@Component
public class CommonUtil {
	
	
	public static String getDate() {
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
		String formatedDate = date.format(today) + " " + time.format(today);
		
		return formatedDate;
	}
	
}
