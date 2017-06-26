package com.st.sm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.st.sm.entity.Teacher;

@Repository
public class TeacherDao {
	@Autowired
	private JdbcTemplate jdbc;
	public List<Teacher> getAll(){
		String sql="select * from sm_teacher";
		return jdbc.query(sql, new TeacherRowMapper());
		
		
	}
	
	//增加
	public void getAdd(Teacher teacher){
		
		jdbc.update("insert into sm_teacher values(?,?,?,?,?,?,?,?,?,?)",
			new Object[]{teacher.getTc_id(),teacher.getTc_name(),teacher.getTc_age(),teacher.getTc_sage(),
			teacher.getTc_motto(),teacher.getTc_image(),teacher.getTc_post(),teacher.getTc_class(),
			teacher.getTc_telephone(),teacher.getTc_address()});
	}
	
	//修改
	public void getUpdate(Teacher teacher){
		jdbc.update("update sm_teacher set TC_NAME=?,TC_AGE=?,TC_SAGE=?,TC_MOTTO=?,TC_IMAGE=?,TC_POST=?,TC_CLASS=?,TC_TELEPHONE=?,TC_ADDRESS=? where TC_ID=?"
						, new Object[]{teacher.getTc_name(),teacher.getTc_age(),teacher.getTc_sage()
								,teacher.getTc_motto(),teacher.getTc_image(),teacher.getTc_post(),teacher.getTc_class()
								,teacher.getTc_telephone(),teacher.getTc_address(),teacher.getTc_id()});
	}
	
	//删除
	public void getDelete(Teacher teacher){
		jdbc.update("delete from sm_teacher where TC_ID=?", new Object[]{teacher.getTc_id()});
	}
	

	
	public class TeacherRowMapper implements RowMapper<Teacher>{

		@Override
		public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
				
			Teacher teacher = new Teacher();
			teacher.setTc_id(rs.getString("TC_ID"));
			teacher.setTc_name(rs.getString("TC_NAME"));
			teacher.setTc_age(rs.getInt("TC_AGE"));
			teacher.setTc_sage(rs.getInt("TC_SAGE"));
			teacher.setTc_motto(rs.getString("TC_MOTTO"));
			teacher.setTc_image(rs.getString("TC_IMAGE"));
			teacher.setTc_post(rs.getString("TC_POST"));
			teacher.setTc_class(rs.getString("TC_CLASS"));
			teacher.setTc_telephone(rs.getString("TC_TELEPHONE"));
			teacher.setTc_address(rs.getString("TC_ADDRESS"));
			
			return teacher;
		}
		
	}
}
