package zhangxiaoyu.DateUtils;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtilsTest {
	@Test
	public void getDaysByDepartedTest () {
		Calendar c = Calendar.getInstance();
		c.set(2019, 7, 15);
		int i = DateUtils.getDaysByDeparted(c.getTime());
		System.out.println(i);
	}
	@Test
	public void getDaysByFutureTest () {
		Calendar c = Calendar.getInstance();
		c.set(2019, 7, 18);
		int i = DateUtils.getDaysByFuture(c.getTime());
		System.out.println(i);
	}
	@Test
	public void getAgeTest () {
		Calendar c = Calendar.getInstance();
		c.set(2018, 7, 15);
		int i = DateUtils.getAge(c.getTime());
		System.out.println(i);
	}
	@Test
	public void getRandomDateTest () {
		Calendar c = Calendar.getInstance();
		c.set(2018, 7, 15);
		for (int i = 0; i <5; i++) {
			Date date = DateUtils.getRandom(c.getTime(), new Date());
			System.out.println(date);
			
		}
	}

	
	@Test
	public void test() {
		Date date = DateUtils.getDateByInitMonth(new Date());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(date));
	}
	
	@Test
	public void test2() {
		
		Calendar c = Calendar.getInstance();
		c.set(2000, 1, 15);
		Date date = DateUtils.getDateByFullMonth(c.getTime());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(date));
		
		
	}
	
	@Test
	public void test3() {
		
/**
 * 拼接下面根据时间范围查询订单的SQL：
String sql = "select * from t_order where create_time>='{1}' and create_time<='{2}' ";
将上面{1}的位置使用DateUtil工具类中的getDateByInitMonth()返回值替换，
将上面{2}的位置使用DateUtil工具类中的
getDateByFullMonth()返回值替换。最后打印出正确拼接的SQL字符串。
 */
		String sql = "select * from t_order where create_time>='{1}' and create_time<='{2}'";
		Date startDate = DateUtils.getDateByInitMonth(new Date());
		Date endDate = DateUtils.getDateByFullMonth(new Date());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		String string = sql.replace("{1}", format.format(startDate)).replace("{2}", format.format(endDate));
		System.out.println(string);
	}
}
