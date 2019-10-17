package zhangxiaoyu.RandomUtil;

import java.util.HashSet;
import java.util.Random;
/**
 * 
 * @ClassName: RandomUtil 
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月9日 上午9:17:30
 */
public class RandomUtil {

	//方法1：返回min-max之间的随机整数（包含min和max值），例如返回1-3之间的随机数，
//	那么返回1或2或3都是正确的，返回4就不对。 (5分)
	public static int random(int min, int max){
		Random r = new Random();
		int x = r.nextInt(max-min+1)+min;
		return x;
	}
	
	
	/**
	 * 
	 * @Title: randomLen 
	 * @Description: 根据长度返回随机数字
	 * @param min
	 * @param max
	 * @param len
	 * @return
	 * @return: String
	 */
	public static String randomLen(int min, int max,int len){
		Random r = new Random();
		String str = "";
		for (int i = 0; i < len; i++) {
			int x = r.nextInt(max-min+1)+min;
			str+=x;
		}
		return str;
	}
	//方法2：在最小值min与最大值max之间截取subs个不重复的随机数。
//	例如在1-10之间取3个不重复的随机数，那么[2,6,9]是对的，[3,5,5]则不对，因为5重复了。
//	应用场景：在100篇文章中随机取10篇文章，月考可能会使用到。 (8分)
	public static int[] subRandom (int min, int max, int subs){
		
		HashSet<Integer> set = new HashSet<>();
		
		while(set.size()!=subs) {
			set.add(random(min, max));
		}
		
		int[] x = new int[subs];
		int y = 0;
		for (int i : set) {
			x[y]=i;
			y++;
		}
		
		return x;
	}
	
	//方法3：返回1个1-9,a-Z之间的随机字符。 (8分)
	public static char randomCharacter (){
		String str = "741852963qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		int i = random(0, str.length()-1);
		
		return str.charAt(i);
	}
	//方法4：返回参数length个字符串(5分)，方法内部要调用randomCharacter()方法 (4分)
	public static String randomString(int length){
		String str = "";
		for (int i = 0; i < length; i++) {
			char c = randomCharacter();
			str += c;
		}
		return str;
	}
}
