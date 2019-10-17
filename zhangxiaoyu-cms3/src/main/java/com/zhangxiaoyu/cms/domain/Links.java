/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: Links.java 
 * @Prject: zhangxiaoyu-cms2
 * @Package: com.zhangxiaoyu.cms.domain 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月22日 下午1:44:46 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.domain;

import java.io.Serializable;
import java.util.Date;

/** 
 * @ClassName: Links 
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月22日 下午1:44:46  
 */
public class Links implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//主键
	
	private String text;//友情链接文本
	
	private String url;//友情链接地址
	
	private Date created;//添加时间
	
	
	@Override
	public String toString() {
		return "Links [id=" + id + ", text=" + text + ", url=" + url + ", created=" + created + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Links other = (Links) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	
}
