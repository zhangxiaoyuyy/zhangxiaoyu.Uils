/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: LinksServiceimplTest.java 
 * @Prject: zhangxiaoyu-cms2
 * @Package: com.zhangxiaoyu.cms.service.impl 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月22日 下午2:31:06 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.service.impl;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.github.pagehelper.PageInfo;
import com.zhangxiaoyu.cms.domain.Links;
import com.zhangxiaoyu.cms.service.LinksService;

/**
 * @ClassName: LinksServiceimplTest
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月22日 下午2:31:06
 */
public class LinksServiceimplTest extends JunitParent {

	@Resource
	private LinksService linksService;

	/**
	 * Test method for
	 * {@link com.zhangxiaoyu.cms.service.impl.LinksServiceimpl#insert(com.zhangxiaoyu.cms.domain.Links)}.
	 */
	@Test
	public void testInsert() {

		Links links = new Links();

		links.setText("京东");
		links.setUrl("https://www.jd.com");
		links.setCreated(new Date());
		linksService.insert(links);

	}

	/**
	 * Test method for
	 * {@link com.zhangxiaoyu.cms.service.impl.LinksServiceimpl#selects(java.lang.Integer, java.lang.Integer)}.
	 */
	@Test
	public void testSelects() {

		PageInfo<Links> info = linksService.selects(0, 10);
		System.err.println(info.getList());
	}

}
