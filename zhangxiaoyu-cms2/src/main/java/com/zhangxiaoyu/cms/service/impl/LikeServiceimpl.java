/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: LikeServiceimpl.java 
 * @Prject: zhangxiaoyu-cms2
 * @Package: com.zhangxiaoyu.cms.service.impl 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月24日 上午11:16:41 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangxiaoyu.cms.dao.LikeMapper;
import com.zhangxiaoyu.cms.domain.Article;
import com.zhangxiaoyu.cms.service.LikeService;

/** 
 * @ClassName: LikeServiceimpl 
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月24日 上午11:16:41  
 */
@Service
public class LikeServiceimpl implements LikeService{

	@Resource
	private LikeMapper likeMapper;

	/* (non Javadoc) 
	 * @Title: insert
	 * @Description: TODO
	 * @param uid
	 * @param aid
	 * @return 
	 * @see com.zhangxiaoyu.cms.service.LikeService#insert(java.lang.Integer, java.lang.Integer) 
	 */
	@Override
	public int insert(Integer uid, Integer aid) {
		// TODO Auto-generated method stub
		return likeMapper.insert(uid, aid);
	}

	
	/* (non Javadoc) 
	 * @Title: select
	 * @Description: TODO
	 * @param uid
	 * @param page
	 * @param pageSize
	 * @return 
	 * @see com.zhangxiaoyu.cms.service.LikeService#select(java.lang.Integer, java.lang.Integer, java.lang.Integer) 
	 */
	@Override
	public PageInfo<Article> select(Integer uid, Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);		
		List<Article> list = likeMapper.select(uid);
		PageInfo<Article> info = new PageInfo<>(list);
		return info;
	}
	
	
}
