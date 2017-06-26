package com.st.sm.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.st.sm.entity.List1;


@Repository
public class ListDao {
	@Autowired
	private JdbcTemplate jdbc;
	public List<List1> getAll(){
		String sql = "select * from SM_LIST";
		return jdbc.query(sql, new ListRowMapper());
	}
	
	//用来返回结果的类
	public class ListRowMapper implements RowMapper<List1>{

		public List1 mapRow(ResultSet rs, int rowNum) throws SQLException {
			List1 list = new List1();
			list.setLs_Id(rs.getString("LS_ID"));
			list.setLs_Date(rs.getDate("LS_DATE"));
			list.setLs_Name(rs.getString("LS_NAME"));
			list.setLs_Remarks(rs.getString("LS_REMARKS"));
			return list;
		}

		
	}

	public void insertList(final List1 list) {
		String sql = "insert SM_LIST values(?,?,?,?)";
		jdbc.update(sql,new PreparedStatementSetter() {
			
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, list.getLs_Id());
				pstmt.setDate(2, new Date(list.getLs_Date().getTime()));
				pstmt.setString(3, list.getLs_Name());
				pstmt.setString(4, list.getLs_Remarks());
			}
		});
	}

	public void updateList(final List1 list) {
		String sql = "update SM_LIST set LS_DATE=?,LS_NAME=?,LS_REMARKS=? where LS_ID=?";
		jdbc.update(sql,new PreparedStatementSetter() {
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setDate(1, new Date(list.getLs_Date().getTime()));
				pstmt.setString(2, list.getLs_Name());
				pstmt.setString(3, list.getLs_Remarks());
				pstmt.setString(4, list.getLs_Id());
			}
		});
	}

	public void deleteList(final List1 list){
		String sql = "delete from SM_LIST where LS_ID=?";
		jdbc.update(sql,new PreparedStatementSetter(){
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, list.getLs_Id());
			}
		});
	}
}
