package com.st.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.sm.entity.News;
import com.st.sm.service.NewsService;

@Controller
@RequestMapping("/newsCon")
public class NewsController { 
	@Autowired
	private NewsService newsService;
	@RequestMapping("addNews")
	@ResponseBody
	public News addNews(News news){
		return newsService.addNews(news);
	}
	
	@RequestMapping("getAll")
	@ResponseBody
	public List<News> getAll(){
		return newsService.getAll();
	}
	@RequestMapping("deleteNews")
	@ResponseBody
	public Integer deleteNews(String id){
		return newsService.deleteNews(id);
	}
	@RequestMapping("updateNews")
	@ResponseBody
	public Integer  updateNews(News news){
		return newsService.updateNews(news);
	}
	
	
}
