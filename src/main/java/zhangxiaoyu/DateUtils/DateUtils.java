package zhangxiaoyu.DateUtils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	/*
	* 方法1：(5分)
	* 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	* 则返回的结果为2019-05-01 00:00:00
	*/
	public static Date getDateByInitMonth(Date src){
		//获取默认的日历类
		Calendar calendar = Calendar.getInstance();
		
		//用传入的日期来初始化日历类
		
		calendar.setTime(src);
		
		//设置当前月
		calendar.set(calendar.DAY_OF_MONTH, 1);
		calendar.set(calendar.HOUR_OF_DAY, 0);
		calendar.set(calendar.MINUTE, 0);
		calendar.set(calendar.SECOND, 0);
		
		return calendar.getTime();
	}
	/*
	* 方法2：(5分)
	* 给一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	*/
	public static Date getDateByFullMonth(Date src){
		Date date = getDateByInitMonth(src);
		Calendar calendar = Calendar.getInstance();
		
		//用传入的日期来初始化日历类
		
		calendar.setTime(date);
		
		//让月加1
		 calendar.add(Calendar.MONTH, 1);
		 //让秒-1
		 calendar.add(Calendar.SECOND, -1);
		
		return calendar.getTime();
	}

}
