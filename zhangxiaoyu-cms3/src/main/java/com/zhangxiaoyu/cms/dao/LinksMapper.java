/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: LinksMapper.java 
 * @Prject: zhangxiaoyu-cms2
 * @Package: com.zhangxiaoyu.cms.dao 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月22日 下午1:47:27 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.dao;

import java.util.List;

import com.zhangxiaoyu.cms.domain.Links;

/** 
 * @ClassName: LinksMapper 
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月22日 下午1:47:27  
 */
public interface LinksMapper {
/**
 * 
 * @Title: insert 
 * @Description: 插入
 * @param links
 * @return
 * @return: int
 */
	int insert(Links links);
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询
	 * @return
	 * @return: List<Links>
	 */
	List<Links> selects();
	
}
