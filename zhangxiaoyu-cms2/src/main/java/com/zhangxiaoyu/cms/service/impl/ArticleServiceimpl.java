/**   

 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: ArticleServiceimpl.java 
 * @Prject: zhangxiaoyu-cms
 * @Package: com.zhangxiaoyu.cms.service.impl 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月16日 上午11:09:13 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangxiaoyu.cms.dao.ArticleMapper;
import com.zhangxiaoyu.cms.domain.Article;
import com.zhangxiaoyu.cms.service.ArticleService;

/** 
 * @ClassName: ArticleServiceimpl 
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月16日 上午11:09:13  
 */
@Service
public class ArticleServiceimpl implements ArticleService {

	@Autowired
	private ArticleMapper mapper;
	/* (non Javadoc) 
	 * @Title: insertSelective
	 * @Description: TODO
	 * @param record
	 * @return 
	 * @see com.zhangxiaoyu.cms.service.ArticleService#insertSelective(com.zhangxiaoyu.cms.domain.Article) 
	 */
	@Override
	public int insertSelective(Article record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	/* (non Javadoc) 
	 * @Title: selectByPrimaryKey
	 * @Description: TODO
	 * @param id
	 * @return 
	 * @see com.zhangxiaoyu.cms.service.ArticleService#selectByPrimaryKey(java.lang.Integer) 
	 */
	@Override
	public Article selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	/* (non Javadoc) 
	 * @Title: selects
	 * @Description: TODO
	 * @param article
	 * @param page
	 * @param pageSize
	 * @return 
	 * @see com.zhangxiaoyu.cms.service.ArticleService#selects(com.zhangxiaoyu.cms.domain.Article, java.lang.Integer, java.lang.Integer) 
	 */
	@Override
	public PageInfo<Article> selects(Article article, Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);		
		List<Article> list = mapper.selects(article);
		PageInfo<Article> info = new PageInfo<>(list);
		return info;
	}

	/* (non Javadoc) 
	 * @Title: updateByPrimaryKeySelective
	 * @Description: TODO
	 * @param record
	 * @return 
	 * @see com.zhangxiaoyu.cms.service.ArticleService#updateByPrimaryKeySelective(com.zhangxiaoyu.cms.domain.Article) 
	 */
	@Override
	public int updateByPrimaryKeySelective(Article record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

}
