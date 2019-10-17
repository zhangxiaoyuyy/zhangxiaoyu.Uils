/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: UserServiceimpl.java 
 * @Prject: zhangxiaoyu-cms
 * @Package: com.zhangxiaoyu.cms.service.impl 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月14日 上午8:46:41 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangxiaoyu.cms.dao.UserMapper;
import com.zhangxiaoyu.cms.domain.User;
import com.zhangxiaoyu.cms.service.UserService;
import com.zhangxiaoyu.cms.untils.CMSRuntimeException;
import com.zhangxiaoyu.cms.untils.Md5Util;
import com.zhangxiaoyu.cms.vo.UserVO;

import zhangxiaoyu.StringUtil.StringUtil;

/**
 * @ClassName: UserServiceimpl
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月14日 上午8:46:41
 */
@Service
public class UserServiceimpl implements UserService {

	@Resource
	private UserMapper mapper;

	/*
	 * (non Javadoc)
	 * 
	 * @Title: insertSelective
	 * 
	 * @Description: TODO
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.zhangxiaoyu.cms.service.UserService#insertSelective(com.zhangxiaoyu.cms.
	 * domain.User)
	 */
	@Override
	public boolean insertSelective(UserVO userVO) {
		// 校验用户名是否重复
		User user = mapper.selectByName(userVO.getUsername());
		// 用户不为空
		if (null != user)
			throw new CMSRuntimeException("该用户已存在!");

		// 校验两次密码是否一致
		if (!userVO.getPassword().equals(userVO.getRepassword()))
			throw new CMSRuntimeException("两次密码不一致!");

		try {
			// 对密码进行加密处理
			userVO.setPassword(Md5Util.md5Encoding(userVO.getPassword()));

			mapper.insertSelective(userVO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CMSRuntimeException("注册用户失败!");
		}
	}

	/*
	 * (non Javadoc)
	 * 
	 * @Title: selectByPrimaryKey
	 * 
	 * @Description: TODO
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.zhangxiaoyu.cms.service.UserService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	/*
	 * (non Javadoc)
	 * 
	 * @Title: updateByPrimaryKeySelective
	 * 
	 * @Description: TODO
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see com.zhangxiaoyu.cms.service.UserService#updateByPrimaryKeySelective(com.
	 * zhangxiaoyu.cms.domain.User)
	 */
	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	/*
	 * (non Javadoc)
	 * 
	 * @Title: selects
	 * 
	 * @Description: TODO
	 * 
	 * @param page
	 * 
	 * @param pageSize
	 * 
	 * @param username
	 * 
	 * @return
	 * 
	 * @see com.zhangxiaoyu.cms.service.UserService#selects(java.lang.Integer,
	 * java.lang.Integer, java.lang.String)
	 */
	@Override
	public PageInfo<User> selects(Integer page, Integer pageSize, String username) {
		PageHelper.startPage(page, pageSize);
		List<User> list = mapper.selects(username);
		PageInfo<User> info = new PageInfo<>(list);

		return info;
	}

	/*
	 * (non Javadoc)
	 * 
	 * @Title: login
	 * 
	 * @Description: TODO
	 * 
	 * @param userVO
	 * 
	 * @return
	 * 
	 * @see
	 * com.zhangxiaoyu.cms.service.UserService#login(com.zhangxiaoyu.cms.vo.UserVO)
	 */
	@Override
	public User login(UserVO userVO) {
		// 校验用户名和密码都非空
		if (!StringUtil.hasText(userVO.getUsername()))
			throw new CMSRuntimeException("用户名不能为空!");
		if (!StringUtil.hasText(userVO.getPassword()))
			throw new CMSRuntimeException("密码不能为空!");
		// 根据用户名查询用户是否存在

		User user = mapper.selectByName(userVO.getUsername());
		if (null == user)
			throw new CMSRuntimeException("无效用户!");
		
		if (1==user.getLocked())
			throw new CMSRuntimeException("用户已被禁用!");
		
		if (!Md5Util.md5Encoding(userVO.getPassword()).equals(user.getPassword()))
			throw new CMSRuntimeException("密码不不正确!!");

		return user;
	}
}
