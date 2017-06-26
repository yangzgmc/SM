package com.st.sm.dao;

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







import com.st.sm.entity.Task;

@Repository
public class TaskDao  {
    @Autowired
    private JdbcTemplate jdbc;
    
    //增加 作业
    public Task addTask(Task task){
		String sql="insert into sm_task value(?,?,?,?) ";
		Object[] params=new Object[]{task.getTk_Id(),task.getTk_Class_Id(),task.getTk_Project_Id(),task.getTk_Content()};
		int[] types=new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
		 jdbc.update(sql,params,types);
		 return task;
		
	}
    //修改 作业
    public Integer updateTask(final Task task){
   	String sql="update sm_task set TK_CLASS_ID=?,TK_PROJECT_ID=?,TK_CONTENT=? where TK_ID=?";
    return	jdbc.update(sql,new PreparedStatementSetter() {
		
		@Override
		public void setValues(PreparedStatement  pstmt) throws SQLException {
          	pstmt.setString(1,task.getTk_Class_Id());
          	pstmt.setString(2, task.getTk_Project_Id());
          	pstmt.setString(3, task.getTk_Content());
          	pstmt.setString(4, task.getTk_Id());
          			
		}
	});
    }
    //查询 作业
    public List<Task> getAll(){
    	String sql="select * from sm_task";
    	 return jdbc.query(sql,new TaskRowMapper());
    }
    public class TaskRowMapper implements RowMapper<Task>{

		@Override
		public Task mapRow(ResultSet rs, int rownum) throws SQLException {
			Task task=new Task();
			task.setTk_Id(rs.getString("TK_ID"));
			task.setTk_Class_Id(rs.getString("TK_CLASS_ID"));
			task.setTk_Project_Id(rs.getString("TK_CONTENT"));
			task.setTk_Content(rs.getString("TK_CONTENT"));
			return task;
		}
    	
    }
    //删除 作业
    public Integer deleteTask(String id){
    	String sql="delete from sm_task where TK_ID=?";
    	 return jdbc.update(sql,id);
    }
}