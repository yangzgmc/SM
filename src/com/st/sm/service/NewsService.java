package com.st.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.sm.dao.NewsDao;
import com.st.sm.entity.News;

@Service
public class NewsService {
   @Autowired
   private NewsDao newsDao;
   public List<News> getAll(){
	   return newsDao.getAll();
   }
   public News addNews(News news){
	   return newsDao.addNews(news);
   }
   public Integer updateNews(News news){
	   return newsDao.updateNews(news);
   }
   public Integer deleteNews(String id){
	   return newsDao.deleteNews(id);
   }
}
