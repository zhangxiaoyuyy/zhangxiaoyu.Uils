/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: Category.java 
 * @Prject: zhangxiaoyu-cms
 * @Package: com.zhangxiaoyu.cms.domain 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月13日 下午2:15:55 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.domain;

import java.io.Serializable;

/** 
 * @ClassName: Category 
 * @Description: 栏目分类
 * @author: zxy
 * @date: 2019年8月13日 下午2:15:55  
 */
public class Category implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Integer channelId;
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
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
