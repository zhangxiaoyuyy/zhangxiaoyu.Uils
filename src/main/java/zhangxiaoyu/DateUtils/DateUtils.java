package zhangxiaoyu.DateUtils;

import java.util.Calendar;
import java.util.Date;

import javax.management.RuntimeErrorException;

public class DateUtils {
	 //获取一个18-70 岁之间的随机日期
	public static Date getRandomDate(int minAge,int maxAge) {
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.YEAR, -minAge);//最小年龄的边界
		
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.YEAR, -maxAge);//最大年龄的边界
		
		return getRandom(c1.getTime(), c2.getTime());
		
	}

	/**
	 * 产生在指定时间范围的随机日期
	 * 
	 * @Title: getRandom
	 * @Description: TODO
	 * @param start
	 * @param end
	 * @return
	 * @return: Date
	 */
	public static Date getRandom(Date start, Date end) {

		long timeStart = start.getTime();
		long endStart = end.getTime();

		long x = (long) (Math.random() * (endStart - timeStart + 1) + timeStart);

		return new Date(x);

	}
	//示例:方法5：求过去日期离今天过去的天数
		public static int getDaysByDeparted (Date departed) {
			long d = departed.getTime();
			long n = new Date().getTime();
			if(d>n)
				throw new RuntimeException("不是过去日期");
			
			return (int) (Math.floor((n-d)/24.0/60/60/1000));
		}
		//示例:方法4：求未来日期离今天还剩的天数
		public static int getDaysByFuture (Date future) {
			long d = future.getTime();
			long n = new Date().getTime();
			if(d<n)
				throw new RuntimeException("不是未来日期");
			
			return (int) (Math.ceil((d-n)/24.0/60/60/1000));
		}
		
		/**
		 * 
		 * @Title: getAge
		 * @Description: 根据传入的日期获取你年龄
		 * @param date
		 * @return
		 * @return: int
		 */
		public static int getAge(Date birthday) {
			Calendar c = Calendar.getInstance();
			
			int yearNow = c.get(Calendar.YEAR);
			int monthNow = c.get(Calendar.MONTH);
			int dayNow = c.get(Calendar.DAY_OF_MONTH);
			
			c.setTime(birthday);
			int yearPre = c.get(Calendar.YEAR);
			int monthPre = c.get(Calendar.MONTH);
			int dayPre = c.get(Calendar.DAY_OF_MONTH);
			
			int age = yearNow-yearPre;
			if(monthPre>monthNow)
				age--;
			if(monthNow==monthPre && dayPre > dayNow)
				age--;
			
			return age;
		}
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
