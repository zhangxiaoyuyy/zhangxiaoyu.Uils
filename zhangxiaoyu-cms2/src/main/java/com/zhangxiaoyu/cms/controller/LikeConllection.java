/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: LikeConllection.java 
 * @Prject: zhangxiaoyu-cms2
 * @Package: com.zhangxiaoyu.cms.controller 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月24日 上午10:10:36 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhangxiaoyu.cms.domain.Article;
import com.zhangxiaoyu.cms.service.LikeService;
import com.zhangxiaoyu.cms.untils.PageUtil;

/**
 * @ClassName: LikeConllection
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月24日 上午10:10:36
 */
@Controller
@RequestMapping("conllection")
public class LikeConllection {

	@Resource
	private LikeService likeService;

	@RequestMapping("to")
	@ResponseBody
	public Boolean tolike(Integer uid, Integer aid) {

		try {
			int i = likeService.insert(uid, aid);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@RequestMapping("toCollectList")
	public String toCollectList(Integer uid, Model model, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "3") Integer pageSize) {

		PageInfo<Article> info = likeService.select(uid, page, pageSize);
		String pages = PageUtil.page(page, info.getPages(), "/conllection/toCollectList", pageSize);
		model.addAttribute("collectList", info.getList());
		model.addAttribute("pages", pages);

		return "/conllection/toCollectList";
	}

}
