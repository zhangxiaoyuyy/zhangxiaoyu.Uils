/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: LinksController.java 
 * @Prject: zhangxiaoyu-cms2
 * @Package: com.zhangxiaoyu.cms.controller 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月22日 下午2:09:47 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhangxiaoyu.cms.domain.Links;
import com.zhangxiaoyu.cms.service.LinksService;
import com.zhangxiaoyu.cms.untils.CMSRuntimeException;
import com.zhangxiaoyu.cms.untils.PageUtil;

/** 
 * @ClassName: LinksController 
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月22日 下午2:09:47  
 */
@Controller
@RequestMapping("links")
public class LinksController {

	@Resource
	private LinksService linksService;
	
	
	@RequestMapping("selects")
	private String selects(@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "5")Integer pageSize,Model model) {
		
		PageInfo<Links> info = linksService.selects(page, pageSize);
		
		String pages = PageUtil.page(page, info.getPages(), "/links/selects", pageSize);
		
		model.addAttribute("links", info.getList());
		
		model.addAttribute("pages", pages);
	
		return "admin/links/links";
	}
	/**
	 * 
	 * @Title: add 
	 * @Description: 去添加
	 * @return
	 * @return: String
	 */
	@RequestMapping("add")
	private String add() {
		
		return "admin/links/add";
		
	}
	
	@PostMapping(value = "save",produces = "text/html; charset=utf-8" )
	@ResponseBody
	public String add(Links links,Model model) {
		links.setCreated(new Date());
		String msg = "ok";
		try {
			linksService.insert(links);
		} catch (CMSRuntimeException e) {
			// TODO Auto-generated catch block
			msg=e.getMessage();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			msg="系统错误";
		}
		return msg;	
	}
	
	
}
