/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: UserVO.java 
 * @Prject: zhangxiaoyu-cms
 * @Package: com.zhangxiaoyu.cms.vo 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月15日 上午9:46:17 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.zhangxiaoyu.cms.domain.User;

/** 
 * @ClassName: UserVO 
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月15日 上午9:46:17  
 */
public class UserVO extends User{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "不能为空")
	@Length(min = 2,max = 8,message = "长度必须6-10之间" )
	private String repassword;

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
