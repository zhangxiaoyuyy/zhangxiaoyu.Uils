/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: IndexController.java 
 * @Prject: zhangsan-cms
 * @Package: com.zhangsan.cms.controller 
 * @Description: TODO
 * @author: charles   
 * @date: 2019年8月20日 上午10:59:49 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zhangxiaoyu.cms.domain.Article;
import com.zhangxiaoyu.cms.domain.Category;
import com.zhangxiaoyu.cms.domain.Channel;
import com.zhangxiaoyu.cms.service.ArticleService;
import com.zhangxiaoyu.cms.service.ChannelService;
import com.zhangxiaoyu.cms.untils.PageUtil;

/** 
 * @ClassName: IndexController 
 * @Description: TODO
 * @author: charles
 * @date: 2019年8月20日 上午10:59:49  
 */

@Controller
public class IndexController {
	
	@Resource
	private ChannelService channelService;

	@Resource
	private ArticleService articleService;

	@GetMapping(value = {"","/","index"})
	public String index(Model model,Article article,
			@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "5")Integer pageSize) {
		
		article.setStatus(1);//只显示审核通过文章
		//左侧的栏目
		List<Channel> channels = channelService.selects();
		model.addAttribute("channels", channels);
		
		//默认显示热点文章
		if(article.getChannelId()==null) {
		//热点文章
		article.setHot(1);//热点文章
		PageInfo<Article> hotArticles = articleService.selects(article, page, pageSize);
		 String pages = PageUtil.page(page, hotArticles.getPages(), "/", pageSize);
		model.addAttribute("hotArticles", hotArticles.getList());
		model.addAttribute("pages", pages);
		}else {
		   //显示栏目下的分类
			List<Category> categorys = channelService.selectsByCid(article.getChannelId());
			model.addAttribute("categorys", categorys);
			
			PageInfo<Article> pageInfo = articleService.selects(article, page, pageSize);
			//栏目或者分类下的文章
			model.addAttribute("articles", pageInfo.getList());
			String url="/?channelId="+article.getChannelId();
			//如果分类ID 不为null 则查询条件加上
			if(article.getCategoryId()!=null)
				url+="&categoryId="+article.getCategoryId();
			  String pages = PageUtil.page(page, pageInfo.getPages(),url, pageSize);
			   model.addAttribute("pages", pages);
		}
		//最新10篇文章
		Article a = new Article();
		a.setStatus(1);
		
		PageInfo<Article> pageInfo = articleService.selects(a, 1, 10);
		
		model.addAttribute("lasts", pageInfo.getList());
		return "index/index";
	}
}
