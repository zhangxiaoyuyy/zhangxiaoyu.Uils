/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: LikeService.java 
 * @Prject: zhangxiaoyu-cms2
 * @Package: com.zhangxiaoyu.cms.service 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月24日 上午11:15:26 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhangxiaoyu.cms.domain.Article;

/** 
 * @ClassName: LikeService 
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月24日 上午11:15:26  
 */
public interface LikeService {

	int insert(Integer uid,Integer aid);


	/** 
	 * @Title: select 
	 * @Description: TODO
	 * @param uid
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: PageInfo<Article>
	 */
	PageInfo<Article> select(Integer uid, Integer page, Integer pageSize);
	
	
}
