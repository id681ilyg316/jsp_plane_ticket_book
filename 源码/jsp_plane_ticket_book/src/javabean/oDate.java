package javabean;

import java.util.Calendar;

/********************
*@author created by matou
*@date  2019��6��14��---����10:34:12
*@IDE	eclipse
*@jdk	1.8.0_161
*********************/
public class oDate {
	public String get_date() {
		String date=null;
		Calendar cal=Calendar.getInstance(); 
		int y=cal.get(Calendar.YEAR);
		int m=cal.get(Calendar.MONTH)+1; 
		int d=cal.get(Calendar.DATE);
		date=y+"-"+m+"-"+d;
		return date;
	}
	 
}
