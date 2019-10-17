/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: LinksService.java 
 * @Prject: zhangxiaoyu-cms2
 * @Package: com.zhangxiaoyu.cms.service 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月22日 下午1:53:40 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhangxiaoyu.cms.domain.Links;

/**
 * @ClassName: LinksService
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月22日 下午1:53:40
 */
public interface LinksService {

	/**
	 * 
	 * @Title: insert
	 * @Description: 插入
	 * @param links
	 * @return
	 * @return: int
	 */
	boolean insert(Links links);

	/**
	 * 
	 * @Title: selects
	 * @Description: 查询
	 * @return
	 * @return: List<Links>
	 */
	PageInfo<Links>  selects(Integer page,Integer pageSize);

}
