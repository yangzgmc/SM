package com.st.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.sm.dao.BookDao;
import com.st.sm.entity.Book;

@Service
public class BookService {
@Autowired
private BookDao bookdao;

public List<Book> getAll(){
	
	return bookdao.getAll();
}

public void getAdd(Book	book){
	bookdao.getAdd(book);
}

public void getUpdate(Book book){
	bookdao.getUpdate(book);
}

public void getDelete(Book book){
	bookdao.getDelete(book);
}

}
