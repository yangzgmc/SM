package com.st.sm.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.st.sm.entity.Project;

@Repository
public class ProjectDao {
   @Autowired
   private JdbcTemplate jdbc;
   //删除 课程
   public Integer deleteProject(String id){
	   String sql="delete from sm_project where PRO_ID=?";
	   return jdbc.update(sql,id);
   }
  //添加 课程
   public Project addProject(Project project){
		String sql="insert into sm_project value(?,?,?,?,?) ";
		Object[] params=new Object[]{project.getPro_Id(),project.getPro_Name(),project.getPro_Date(),project.getPro_Week(),project.getPro_Class_Id()};
		int[] types=new int[]{Types.VARCHAR,Types.VARCHAR,Types.DATE,Types.VARCHAR,Types.VARCHAR};
		 jdbc.update(sql,params,types);
		 return project;
		
	}
   //查看 课程
   public List<Project> getAll(){
		String sql="select * from sm_project";
		return jdbc.query(sql, new ProjectRowMapper());
	} 
	//查询返回结果的类
	public class ProjectRowMapper implements RowMapper<Project>{
    //返回结果集
		public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
			Project project=new Project();
			project.setPro_Id(rs.getString("PRO_ID"));
			project.setPro_Name(rs.getString("PRO_NAME"));
			project.setPro_Date(new Date(rs.getDate("PRO_DATE").getTime()));
			project.setPro_Week(rs.getString("PRO_WEEK"));
			project.setPro_Class_Id(rs.getString("PRO_CLASS_ID"));
			return project;
		}
		
		
	}
	//修改课程
	public Integer updatePorject(final Project project){
		String sql="update sm_project set PRO_NAME=?,PRO_DATE=?,PRO_WEEK=?,PRO_CLASS_ID=? where PRO_ID=?";
		 return jdbc.update(sql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1,project.getPro_Name());
				pstmt.setDate(2, (Date) project.getPro_Date());
				pstmt.setString(3, project.getPro_Week());
				pstmt.setString(4, project.getPro_Class_Id());
				pstmt.setString(5, project.getPro_Id());
			}
		});
	}
}
