/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: PattenUtils.java 
 * @Prject: zhangxiaoyu.Utils
 * @Package: zhangxiaoyu.PattenUtil 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月10日 下午9:27:42 
 * @version: V1.0   
 */
package zhangxiaoyu.PattenUtil;

/** 
 * @ClassName: PattenUtils 
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月10日 下午9:27:42  
 */
public class PattenUtils {
/**
 * 
 * @Title: getNumFormUrl 
 * @Description: 截取地址中的最后的数字
 * @param str
 * @return
 * @return: Integer
 */
	public static Integer getLastNumFormUrl(String str) {
		String[] split = str.split("\\D+");
		String string = split[split.length-1];
		
		return Integer.parseInt(string);
	}
	
	/**
	 * 
	 * @Title: getFirstNumFormUrl 
	 * @Description: 截取地址中的第一的数字
	 * @param str
	 * @return
	 * @return: String
	 */
	public static String getFirstNumFormUrl(String str) {
		String[] split = str.split("\\D");
		String string = split[0];
		
		return string;
	}
}
