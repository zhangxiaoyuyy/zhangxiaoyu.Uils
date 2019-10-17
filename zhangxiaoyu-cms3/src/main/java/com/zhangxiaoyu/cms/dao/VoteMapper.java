/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: VoteMapper.java 
 * @Prject: zhangxiaoyu-cms3
 * @Package: com.zhangxiaoyu.cms.dao 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月27日 上午10:08:46 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.dao;

import java.util.List;
import java.util.Map;

import com.zhangxiaoyu.cms.domain.Vote;

/**
 * @ClassName: VoteMapper
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月27日 上午10:08:46
 */
public interface VoteMapper {

	//

	// 投票
	int insert(Vote vote);

	/** 
	 * @Title: selects 
	 * @Description:  查询
	 * @param id
	 * @return
	 * @return: List<Vote>
	 */
	List<Map> selects(Integer id);
}
