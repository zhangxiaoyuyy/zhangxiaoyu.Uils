/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: VoteService.java 
 * @Prject: zhangxiaoyu-cms3
 * @Package: com.zhangxiaoyu.cms.service 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月27日 上午9:58:13 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.service;

import java.util.List;
import java.util.Map;

import com.zhangxiaoyu.cms.domain.Vote;

/** 
 * @ClassName: VoteService 
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月27日 上午9:58:13  
 */
public interface VoteService {

	//查询
	List<Map> selects(Integer id);
	
	//投票
	int insert(Vote vote);

}
