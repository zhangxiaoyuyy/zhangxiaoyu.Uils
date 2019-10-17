/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: Channel.java 
 * @Prject: zhangxiaoyu-cms
 * @Package: com.zhangxiaoyu.cms.domain 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月13日 下午2:25:05 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.domain;

import java.io.Serializable;

/** 
 * @ClassName: Channel 
 * @Description: 栏目
 * @author: zxy
 * @date: 2019年8月13日 下午2:25:05  
 */
public class Channel implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private  String description;
	private String iocn;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIocn() {
		return iocn;
	}
	public void setIocn(String iocn) {
		this.iocn = iocn;
	}
	

	
}
