/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: ArticleController.java 
 * @Prject: zhangsan-cms
 * @Package: com.zhangsan.cms.controller 
 * @Description: TODO
 * @author: charles   
 * @date: 2019年8月15日 上午11:04:34 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.zhangxiaoyu.cms.domain.Article;
import com.zhangxiaoyu.cms.domain.User;
import com.zhangxiaoyu.cms.domain.Vote;
import com.zhangxiaoyu.cms.service.ArticleService;
import com.zhangxiaoyu.cms.service.VoteService;
import com.zhangxiaoyu.cms.untils.ArticleEnum;
import com.zhangxiaoyu.cms.untils.CMSContant;
import com.zhangxiaoyu.cms.untils.CookieUtil;
import com.zhangxiaoyu.cms.untils.JsonUtil;
import com.zhangxiaoyu.cms.untils.PageUtil;
import com.zhangxiaoyu.cms.vo.ArticleVO;

/**
 * @ClassName: ArticleController
 * @Description: 文章模块
 * @author: charles
 * @param <V>
 * @date: 2019年8月15日 上午11:04:34
 */
@RequestMapping("article")
@Controller
public class ArticleController<V> {

	@Resource
	private ArticleService articleService;
	
	@Resource
	private VoteService voteService;

	Gson gson = new Gson();


	/**
	 * 更新访问量
	 * 
	 * @Title: updateHits
	 * @Description:
	 * @return: void
	 */
	@PostMapping("updateHits")
	public void updateHits(Article article, HttpServletRequest request, HttpServletResponse response) {
		// 获取hitId 的cookie,
		Cookie cookie = CookieUtil.getCookie(request, "hitId");
		// 如果已经更新过则不更新
		if (CookieUtil.isCheck(cookie, article.getId() + "", response)) {
			// 获取当前的文章点击量
			Article a2 = articleService.selectByPrimaryKey(article.getId());
			// //增加点击量+1
			article.setHits(a2.getHits() + 1);
			articleService.updateByPrimaryKeySelective(article);

		}

	}

	/**
	 * 
	 * @Title: check
	 * @Description: 审核文章
	 * @param article
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("check")
	public boolean check(Article article) {
		return articleService.updateByPrimaryKeySelective(article) > 0;

	}

	/**
	 * 显示文章明细
	 * 
	 * @Title: select
	 * @Description: TODO
	 * @param id
	 * @param model
	 * @return
	 * @return: String
	 */
	@GetMapping("select")
	public String select(Integer id, Model model) {
		Article article = articleService.selectByPrimaryKey(id);
		model.addAttribute("article", article);
		return "article/detail";

	}

	/**
	 * 显示文章明细
	 * 
	 * @Title: select
	 * @Description: TODO
	 * @param id
	 * @param model
	 * @return
	 * @return: String
	 */
	@GetMapping("selectByAdmin")
	public String selectByAdmin(Integer id, Model model) {
		Article article = articleService.selectByPrimaryKey(id);
		model.addAttribute("article", article);
		return "admin/article/detail";

	}

	/**
	 * 管理员 查询文章标题
	 * 
	 * @Title: select
	 * @Description: TODO
	 * @param page
	 * @param pageSize
	 * @param article
	 * @param model
	 * @return
	 * @return: String
	 */
	@GetMapping("selectsByAdmin")
	public String selectsByAdmin(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "3") Integer pageSize, Article article, Model model) {
		PageInfo<Article> info = articleService.selects(article, page, pageSize);

		String pages = PageUtil.page(page, info.getPages(), "/article/selectsByAdmin", pageSize);

		model.addAttribute("articles", info.getList());
		model.addAttribute("pages", pages);
		model.addAttribute("article", article);
		return "admin/article/titles";

	}

	/**
	 * 返回到文章标题
	 * 
	 * @Title: select
	 * @Description: TODO
	 * @param page
	 * @param pageSize
	 * @param article
	 * @param model
	 * @return
	 * @return: String
	 */
	@GetMapping("selects")
	public String select(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "3") Integer pageSize, Article article, Model model) {
		PageInfo<Article> info = articleService.selects(article, page, pageSize);

		String pages = PageUtil.page(page, info.getPages(), "/article/selects", pageSize);

		model.addAttribute("articles", info.getList());
		model.addAttribute("pages", pages);
		model.addAttribute("article", article);
		return "article/titles";

	}

	/**
	 * 去发布文章页面
	 * 
	 * @Title: publish
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@GetMapping("publish")
	public String publish() {

		return "article/publish";
	}

	/**
	 * 发布图片集
	 * 
	 * @Title: publishPic
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@GetMapping("publishPic")
	public String publishPic() {

		return "article/publishpic";
	}

	/**
	 * 发布文章
	 * 
	 * @Title: publish
	 * @Description: TODO
	 * @param article
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("publish")
	public boolean publish(Article article, MultipartFile file, HttpServletRequest request) {

		if (!file.isEmpty()) {
			String path = "d:/pic/";// 文件上传的路径

			// 获取原始名称
			String filename = file.getOriginalFilename();
			// 为了防止文件名称重复.采用随机的UUID的值
			String newFilename = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));

			File f = new File(path + newFilename);

			try {
				file.transferTo(f);// 把文件写入硬盘
				article.setPicture(newFilename);

			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		article.setHits(0);
		article.setStatus(0);
		article.setCreated(new Date());
		article.setUpdated(new Date());
		HttpSession session = request.getSession(false);
		if (null == session)
			return false;
		User user = (User) request.getSession().getAttribute(CMSContant.SESSION_GENERAL);
		article.setUserId(user.getId());
		article.setDeleted(0);
		article.setHot(0);

		return articleService.insertSelective(article) > 0;

	}

	/**
	 * 获取所有的图片集
	 * 
	 * @Title: selectsPic
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@GetMapping("selectPic")
	public String selectsPic(Model model, Integer id) {
		List<ArticleVO> list = new ArrayList<>();

		Article article = articleService.selectByPrimaryKey(id);
		// 获取json串
		String string = article.getContent();
		// 解析字符串
		JsonArray jsonArray = new JsonParser().parse(string).getAsJsonArray();
		for (JsonElement jsonElement : jsonArray) {
			// 把json串转为java对象
			ArticleVO vo = gson.fromJson(jsonElement, ArticleVO.class);
			list.add(vo);
		}

		model.addAttribute("images", list);

		return "article/detailpic";// 显示图片明细

	}

	/**
	 * 发布文章
	 * 
	 * @Title: publishPic
	 * @Description: TODO
	 * @param article
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("publishPic")
	public boolean publishPic(ArticleVO article, MultipartFile[] files, String[] descr, HttpServletRequest request) {

		// 发布文章内容
		article.setContentType(ArticleEnum.IMAGE.getCode());

		List<Article> list = new ArrayList<>();
		String newFimename = "";

		if (files.length > 0) {
			int i = 0;

			for (MultipartFile file : files) {

				if (!file.isEmpty()) {
					ArticleVO vo = new ArticleVO();

					String path = "d:/pic/";// 文件上传的路径

					// 获取原始名称
					String filename = file.getOriginalFilename();
					// 为了防止文件名称重复.采用随机的UUID的值
					String newFilename = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));

					File f = new File(path + newFilename);

					try {
						file.transferTo(f);// 把文件写入硬盘
						// 封装图片描述
						vo.setDescr(descr[i]);
						i++;
						// 封装url
						vo.setUrl(newFilename);
						list.add(vo);
					} catch (IllegalStateException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		}
		article.setPicture(newFimename);

		String json = gson.toJson(list);
		article.setContent(json);

		article.setHits(0);
		article.setStatus(0);
		article.setCreated(new Date());
		article.setUpdated(new Date());
		HttpSession session = request.getSession(false);
		if (null == session)
			return false;
		User user = (User) request.getSession().getAttribute(CMSContant.SESSION_GENERAL);
		article.setUserId(user.getId());
		article.setDeleted(0);
		article.setHot(0);

		return articleService.insertSelective(article) > 0;
	}

	/**
	 * 
	 * @Title: publishVote 
	 * @Description: 去投票
	 * @return
	 * @return: String
	 */
	@GetMapping("publishVote")
	public String publishVote() {

		return "article/publishvote";
	}

	
	@ResponseBody
	@PostMapping("publishVote")
	public boolean publishVote(ArticleVO article,  String[] descr, HttpServletRequest request) {

		// 发布文章内容
		article.setContentType(ArticleEnum.JSON.getCode());

		List<Map> list = new ArrayList<>();
		
		char x = 'A';
		if(descr!=null&&descr.length>0) {
			for (int i = 0; i < descr.length; i++) {
				HashMap<String, Object> map = new HashMap<>();
				map.put(String.valueOf((char)(x+i)), descr[i]);
				list.add(map);
			}
		}

		String string = JsonUtil.gsonString(list);
		article.setContent(string);
		article.setHits(0);
		article.setStatus(0);
		article.setCreated(new Date());
		article.setUpdated(new Date());
		HttpSession session = request.getSession(false);
		if (null == session)
			return false;
		User user = (User) request.getSession().getAttribute(CMSContant.SESSION_GENERAL);
		article.setUserId(user.getId());
		article.setDeleted(0);
		article.setHot(0);

		return articleService.insertSelective(article) > 0;
	}

	/**
	 *
	 * 
	 * @Title: select
	 * @Description: 发起投票明细
	 * @param id
	 * @param model
	 * @return
	 * @return: String
	 */
	@GetMapping("selectVote")
	public String selectVote(Integer id, Model model) {
		Article article = articleService.selectByPrimaryKey(id);
		
		//把json转为java
		List<Map<String, Object>> list = JsonUtil.gsonToListMaps(article.getContent());
		
		model.addAttribute("article", article);
		model.addAttribute("mapList", list);
		
		//查询投票结构
		List<Map> mapListVote = voteService.selects(id);
		model.addAttribute("mapListVote", mapListVote);
		return "article/detailvote";
		
	}
	
	@ResponseBody
	@PostMapping("vote")
	public boolean vote(Vote v,HttpServletRequest request,HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			User u = (User)session.getAttribute(CMSContant.SESSION_GENERAL);
			if(u!=null) {
				v.setUserId(u.getId());
			}
			voteService.insert(v);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

}
