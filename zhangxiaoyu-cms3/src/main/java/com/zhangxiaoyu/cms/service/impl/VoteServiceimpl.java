/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: VoteServiceimpl.java 
 * @Prject: zhangxiaoyu-cms3
 * @Package: com.zhangxiaoyu.cms.service.impl 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月27日 上午10:06:11 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangxiaoyu.cms.dao.VoteMapper;
import com.zhangxiaoyu.cms.domain.Vote;
import com.zhangxiaoyu.cms.service.VoteService;

/** 
 * @ClassName: VoteServiceimpl 
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月27日 上午10:06:11  
 */
@Service
public class VoteServiceimpl implements VoteService{

	@Resource
	private VoteMapper mapper;
	/* (non Javadoc) 
	 * @Title: selects
	 * @Description: TODO
	 * @return 
	 * @see com.zhangxiaoyu.cms.service.VoteService#selects() 
	 */
	@Override
	public List<Map> selects(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selects(id);
	}

	/* (non Javadoc) 
	 * @Title: insert
	 * @Description: TODO
	 * @param vote
	 * @return 
	 * @see com.zhangxiaoyu.cms.service.VoteService#insert(com.zhangxiaoyu.cms.domain.Vote) 
	 */
	@Override
	public int insert(Vote vote) {
		// TODO Auto-generated method stub
		return mapper.insert(vote);
	}

	
}
