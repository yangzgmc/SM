package com.st.sm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.st.sm.entity.Student;



@Repository
public class StudentDao {
	@Autowired
	private JdbcTemplate jdbc;
	
	//查询
	public List<Student> getAll(){
		String sql = "select * from sm_student";
		return jdbc.query(sql, new StudentRowMapper());
		
	}
	//增加学生数据
	public void getAdd(Student st){
		jdbc.update("insert into sm_student values(?,?,?,?,?,?,?,?,?,?)", 
				new Object[]{st.getSt_id(),st.getSt_name(),st.getSt_sex(),st.getSt_image(),st.getSt_address(),
				st.getSt_phone(),st.getSt_hostel(),st.getSt_tc_id(),st.getSt_class_id(),st.getSt_age()});
	}
	
	//修改
	public void getUpdate(Student st){
		jdbc.update("update sm_student set ST_NAME=?,ST_SEX=?,ST_IMAGE=?,ST_ADDRESS=?,ST_PHONE=?,ST_HOSTEL=?,ST_TC_ID=?,ST_CLASS_ID=?,ST_AGE=? where ST_ID=?", 
				new Object[]{st.getSt_name(),st.getSt_sex(),st.getSt_image(),st.getSt_address(),
				st.getSt_phone(),st.getSt_hostel(),st.getSt_tc_id(),st.getSt_class_id(),st.getSt_age(),st.getSt_id()});
	}
	
	//删除
	public void getDelete(Student st){
		jdbc.update("delete from sm_student where ST_ID=?", new Object[]{st.getSt_id()});
	}
	
	
	public class StudentRowMapper implements RowMapper<Student>{

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Student student = new Student();
			student.setSt_id(rs.getString("ST_ID"));
			student.setSt_name(rs.getString("ST_NAME"));
			student.setSt_sex(rs.getInt("ST_SEX"));
			student.setSt_image(rs.getString("ST_IMAGE"));
			student.setSt_address(rs.getString("ST_ADDRESS"));
			student.setSt_phone(rs.getString("ST_PHONE"));
			student.setSt_hostel(rs.getString("ST_HOSTEL"));
			student.setSt_tc_id(rs.getString("ST_TC_ID"));
			student.setSt_class_id(rs.getString("ST_CLASS_ID"));
			student.setSt_age(rs.getInt("ST_AGE"));
			
			return student;
		}
		
	}
	
	
}
