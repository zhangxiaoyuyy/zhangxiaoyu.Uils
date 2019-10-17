/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: Slide.java 
 * @Prject: zhangxiaoyu-cms
 * @Package: com.zhangxiaoyu.cms.domain 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月13日 下午2:28:39 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.domain;

import java.io.Serializable;
/**
 * 
 * @ClassName: Slide 
 * @Description: 广告
 * @author: charles
 * @date: 2019年7月17日 上午11:10:03
 */
public class Slide implements Serializable {
    /**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String title;

    private String picture;

    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}