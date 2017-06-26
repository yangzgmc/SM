package com.st.sm.entity;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
	private String news_Id;
	private Date  news_Date;
	private String news_Title;
	private String news_Content;
	private String news_Image;
	public String getNews_Id() {
		return news_Id;
	}
	public void setNews_Id(String news_Id) {
		this.news_Id = news_Id;
	}
	public Date getNews_Date() {
		return news_Date;
	}
	public void setNews_Date(Date news_Date) {
		this.news_Date = news_Date;
	}
	public String getNews_Title() {
		return news_Title;
	}
	public void setNews_Title(String news_Title) {
		this.news_Title = news_Title;
	}
	public String getNews_Content() {
		return news_Content;
	}
	public void setNews_Content(String news_Content) {
		this.news_Content = news_Content;
	}
	public String getNews_Image() {
		return news_Image;
	}
	public void setNews_Image(String news_Image) {
		this.news_Image = news_Image;
	}

	

}
