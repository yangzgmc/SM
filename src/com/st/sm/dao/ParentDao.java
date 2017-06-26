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

import com.st.sm.entity.Parent;

@Repository
public class ParentDao {
	@Autowired
	private JdbcTemplate jdbc;  
	//查询家人信息
	public List<Parent> getAll(){
		String sql="select * from sm_parent";
		return jdbc.query(sql, new ParentRowMapper());
	} 
	//查询返回结果的类
	public class ParentRowMapper implements RowMapper<Parent>{
     //返回结果集
		public Parent mapRow(ResultSet rs, int rowNum) throws SQLException {
			Parent parent=new Parent();
			parent.setPa_Id(rs.getString("PA_ID"));
			parent.setSt_Id(rs.getString("ST_ID"));
			parent.setPa_Name(rs.getString("PA_NAME"));
			parent.setPa_Type(rs.getInt("PA_TYPE"));
			parent.setPa_Phone(rs.getString("PA_PHONE"));
			return parent;
		}
		
		
	}
	//添加家长信息
	public Parent addParent(Parent parent){
		String sql="insert into sm_parent value(?,?,?,?,?) ";
		Object[] params=new Object[]{parent.getPa_Id(),parent.getSt_Id(),parent.getPa_Name(),parent.getPa_Type(),parent.getPa_Phone()};
		int[] types=new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.VARCHAR};
		 jdbc.update(sql,params,types);
		 return parent;
		
	}
     //查询家长id
//	 public Parent selectParentId(String id){
//      String sql="select * from sm_parent where PA_ID=?";
//      return jdbc.queryForObject(sql,new ParentRowMapper(), id);
//	 }
	//修改家长信息
	public void updateParent( final Parent parent){
		String sql="update sm_parent set ST_ID=?,PA_NAME=?,PA_TYPE=?,PA_PHONE=? where PA_ID=?";
		jdbc.update(sql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1,parent.getSt_Id());
				pstmt.setString(2, parent.getPa_Name());
				pstmt.setInt(3, parent.getPa_Type());
				pstmt.setString(4, parent.getPa_Phone());
				pstmt.setString(5, parent.getPa_Id());
			}
		});
	}
		
	
}
