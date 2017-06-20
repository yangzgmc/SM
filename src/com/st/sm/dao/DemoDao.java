package com.st.sm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DemoDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	public int getAllCount(){
		String sql="select count(*) from Demo";
		return jdbc.queryForInt(sql);
	}
	
	
	
	
	
	
	//仅仅是为了测试
}
