/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: ArticleEnum.java 
 * @Prject: zhangxiaoyu-cms2
 * @Package: com.zhangxiaoyu.cms.untils 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月24日 上午8:27:43 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.untils;

/** 
 * @ClassName: ArticleEnum 
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月24日 上午8:27:43  
 */
public enum ArticleEnum {

	//文章类型
	HTML(1,"HTML"),IMAGE(2,"IMAGE");
	
	private Integer code;
	private String name;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	ArticleEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}
	
	
	
}
