package zhangxiaoyu.RandomUtil;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomUtilTest {

	
	@Test
	public void testRandomLen() {
		for (int i = 0; i < 5; i++) {
			String len = RandomUtil.randomLen(0, 9, 13);
			System.out.println(len);
		}
		
	}
	@Test
	public void testRandom() {
		for (int i = 0; i <10; i++) {
			
			int j = RandomUtil.random(1, 10);
			System.out.println(j);
		}
		
	}

	@Test
	public void testSubRandom() {
		
			
			int[] random = RandomUtil.subRandom(5, 11, 3);
			for (int j : random) {
				System.out.print(j);
			}
			System.out.println();
		
	}

	@Test
	public void testRandomCharacter() {
		for (int i = 0; i < 10; i++) {
			
			char c = RandomUtil.randomCharacter();
			System.out.print(c);
			System.out.print("  ");
		}
		
	}

	@Test
	public void testRandomString() {
		String string = RandomUtil.randomString(6);
		System.out.println(string);
	}

}
