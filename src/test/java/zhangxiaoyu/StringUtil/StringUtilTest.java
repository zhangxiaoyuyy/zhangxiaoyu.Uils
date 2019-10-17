package zhangxiaoyu.StringUtil;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;
import java.util.Random;

import org.junit.Test;
import org.w3c.dom.ranges.Range;

public class StringUtilTest {

	@Test
	public void RandomEmil() {
		/*
		 * Random r = new Random(); System.out.println(r.nextInt(10));
		 */

		for (int i = 0; i < 5; i++) {
			String emil = StringUtil.RandomEmil(0, 9);
			System.out.println(emil);

		}

	}

	@Test
	public void testSex() {
		String sex = StringUtil.generateChineseSex();
		System.out.println(sex);
	}

	@Test
	public void testHasLength() {
		boolean b = StringUtil.hasLength("");
		System.out.println(b);
	}

	@Test
	public void teststrToInt() {
		Integer integer = StringUtil.strToInt("8520");
		System.out.println(integer);
	}

	@Test
	public void teststrToDate() {
		Date date = StringUtil.strToDate("20190805");
		System.out.println(date);
	}

	@Test
	public void testHasText() {
		fail("Not yet implemented");
	}

	@Test
	public void testRandomChineseString() {

		String string = StringUtil.randomChineseString(100);
		System.out.println(string);
	}

	@Test
	public void testGenerateChineseName() {
		for (int i = 0; i < 5; i++) {
			String name = StringUtil.generateChineseName();
			System.out.println(name);
		}

	}

}
