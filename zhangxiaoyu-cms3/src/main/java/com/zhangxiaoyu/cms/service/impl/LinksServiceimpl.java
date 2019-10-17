/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: LinksServiceimpl.java 
 * @Prject: zhangxiaoyu-cms2
 * @Package: com.zhangxiaoyu.cms.service.impl 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月22日 下午1:55:29 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangxiaoyu.cms.dao.LinksMapper;
import com.zhangxiaoyu.cms.domain.Links;
import com.zhangxiaoyu.cms.service.LinksService;
import com.zhangxiaoyu.cms.untils.CMSRuntimeException;

import zhangxiaoyu.StringUtil.StringUtil;

/**
 * @ClassName: LinksServiceimpl
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月22日 下午1:55:29
 */
@Service
public class LinksServiceimpl implements LinksService {

	@Resource
	private LinksMapper mapper;

	/*
	 * (non Javadoc)
	 * 
	 * @Title: insert
	 * 
	 * @Description: TODO
	 * 
	 * @param links
	 * 
	 * @return
	 * 
	 * @see
	 * com.zhangxiaoyu.cms.service.LinksService#insert(com.zhangxiaoyu.cms.domain.
	 * Links)
	 */
	@Override
	public boolean insert(Links links) {
		// TODO Auto-generated method stub.
		// 检查URl是否合法不合法就抛出自定义异常
		if (!StringUtil.isHttpUrl(links.getUrl()))
			throw new CMSRuntimeException("不是有效URL");
		return mapper.insert(links) > 0;
	}

	/*
	 * (non Javadoc)
	 * 
	 * @Title: selects
	 * 
	 * @Description: TODO
	 * 
	 * @return
	 * 
	 * @see com.zhangxiaoyu.cms.service.LinksService#selects()
	 */
	@Override
	public PageInfo<Links> selects(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub

		PageHelper.startPage(page, pageSize);
		
		List<Links> list = mapper.selects();
		
		PageInfo<Links> info = new PageInfo<>(list);

		return info;
	}

}
