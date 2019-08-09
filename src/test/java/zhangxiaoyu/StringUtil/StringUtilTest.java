package zhangxiaoyu.StringUtil;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testHasLength() {
		boolean b = StringUtil.hasLength("");
		System.out.println(b);
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
