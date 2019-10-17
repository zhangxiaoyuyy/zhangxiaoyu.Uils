/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: PattenUtil.java 
 * @Prject: zhangxiaoyu.Utils
 * @Package: zhangxiaoyu.PattenUtil 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月11日 下午9:00:25 
 * @version: V1.0   
 */
package zhangxiaoyu.PattenUtil;

/** 
 * @ClassName: PattenUtil 
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月11日 下午9:00:25  
 */
public class PattenUtil {

	/**
	 * 
	 * @Title: getLastNumFormUrl 
	 * @Description:从url中获取最后的数字
	 * @return
	 * @return: Integer
	 */

	public static Integer getLastNumFormUrl(String url) {
	    String[] split = url.split("\\D+");
	    
	     String num = split[split.length-1];
		
	     return Integer.parseInt(num);
		
	}
	
	/**
	 * 
	 * @Title: getFirstNumFormUrl 
	 * @Description: 获取第一个数字
	 * @param url
	 * @return
	 * @return: Integer
	 */
	public static String getFirstNumFormUrl(String url) {
	    String[] split = url.split("\\D+");
	    
		
	     return split[1];
		
	}
	
	
	
	
	
		
}
