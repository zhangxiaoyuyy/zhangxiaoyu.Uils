package com.zhangxiaoyu.cms.dao;

import java.util.List;

import com.zhangxiaoyu.cms.domain.Channel;

public interface ChannelMapper {
	/**
	 * 
	 * @Title: selects 
	 * @Description: 所有的栏目
	 * @return
	 * @return: List<Channel>
	 */
	List<Channel> selects();
	
	
    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
}