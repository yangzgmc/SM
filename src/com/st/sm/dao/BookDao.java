package com.st.sm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.st.sm.entity.Book;

@Repository
public class BookDao {
@Autowired
private JdbcTemplate jdbc;

public List<Book> getAll(){
	String sql = "select * from sm_book";
	return jdbc.query(sql, new BookRowMapper());
	
}

public void getAdd(Book book){
	jdbc.update("insert into sm_book values(?,?,?,?,?,?,?)", 
			new Object[]{book.getBk_id(),book.getBk_class_id(),
			book.getBk_name(),book.getBk_author(),book.getBk_address(),book.getBk_summary(),book.getBk_image()});
}

public void getUpdate(Book book){
	jdbc.update("update sm_book set BK_CLASS_ID=?,BK_NAME=?,BK_AUTHOR=?,BK_ADDRESS=?,BK_SUMMARY=?,BK_IMAGE=? where BK_ID=?",
			new Object[]{book.getBk_class_id(),book.getBk_name(),book.getBk_author(),
			book.getBk_address(),book.getBk_summary(),book.getBk_image(),book.getBk_id()});
}

public void getDelete(Book book){
	jdbc.update("delete from sm_book where BK_ID=?", new Object[]{book.getBk_id()});
}




public class BookRowMapper implements RowMapper<Book>{

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

			Book book = new Book();
			book.setBk_id(rs.getString("BK_ID"));
			book.setBk_class_id(rs.getString("BK_CLASS_ID"));
			book.setBk_name(rs.getString("BK_NAME"));
			book.setBk_author(rs.getString("BK_AUTHOR"));
			book.setBk_address(rs.getString("BK_ADDRESS"));
			book.setBk_summary(rs.getString("BK_SUMMARY"));
			book.setBk_image(rs.getString("BK_IMAGE"));
		return book;
	}
	
}
}
