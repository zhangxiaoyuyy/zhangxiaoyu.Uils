/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: LikeMapper.java 
 * @Prject: zhangxiaoyu-cms2
 * @Package: com.zhangxiaoyu.cms.dao 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月24日 上午11:17:49 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zhangxiaoyu.cms.domain.Article;

/** 
 * @ClassName: LikeMapper 
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月24日 上午11:17:49  
 */
public interface LikeMapper {

	int insert(@Param("uid")Integer uid,@Param("aid")Integer aid);

	/** 
	 * @Title: select 
	 * @Description: TODO
	 * @param uid
	 * @return
	 * @return: List<Integer>
	 */
	List<Article> select(@Param("uid")Integer uid);
}
