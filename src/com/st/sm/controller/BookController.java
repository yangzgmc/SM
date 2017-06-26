package com.st.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.sm.entity.Book;
import com.st.sm.service.BookService;

@Controller
@RequestMapping("/bookCon")
public class BookController {
	@Autowired
	private BookService bookservice;
	
	@RequestMapping("getAll")
	@ResponseBody
	public List<Book> getAll(){
		return bookservice.getAll();
	}
	
	@RequestMapping("getAdd")
	public void getAdd(Book book){
		bookservice.getAdd(book);
	}
	
	@RequestMapping("getUpdate")
	public void getUpdate(Book book){
		bookservice.getUpdate(book);
	}
	
	@RequestMapping("getDelete")
	public void getDelete(Book book){
		bookservice.getDelete(book);
	}
	
	
	
	
}
