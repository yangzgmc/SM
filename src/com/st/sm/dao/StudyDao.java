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

import com.st.sm.entity.Study;

@Repository
public class StudyDao {
	@Autowired
	private JdbcTemplate jdbc;
	public List<Study> getAll(){
		String sql = "select * from SM_STUDY";
		return jdbc.query(sql,new StudyMapper());
	}
	public class StudyMapper implements RowMapper<Study>{
		public Study mapRow(ResultSet rs, int rowNum) throws SQLException {
			Study study = new Study();
			study.setStu_Id(rs.getString("STU_ID"));
			study.setStu_Title(rs.getString("STU_TITLE"));
			study.setStu_Content(rs.getString("STU_CONTENT"));
			study.setStu_Date(rs.getDate("STU_DATE"));
			study.setStu_Type(rs.getString("STU_TYPE"));
			study.setStu_Age(rs.getString("STU_AGE"));
			return study;
		}
	}
	public void insertStudy(final Study study) {
		String sql = "insert SM_STUDY values(?,?,?,?,?,?)";
		jdbc.update(sql,new PreparedStatementSetter() {
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, study.getStu_Id());
				pstmt.setString(2, study.getStu_Title());
				pstmt.setString(3, study.getStu_Content());
				pstmt.setDate(4, new Date(study.getStu_Date().getTime()));
				pstmt.setString(5, study.getStu_Type());
				pstmt.setString(6, study.getStu_Age());
			}
		});
	}
	public void updateStudy(final Study study) {
		String sql = "update SM_STUDY set STU_TITLE=?,STU_CONTENT=?,STU_DATE=?,STU_TYPE=?,STU_AGE=? where STU_ID=?";
		jdbc.update(sql,new PreparedStatementSetter() {
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, study.getStu_Title());
				pstmt.setString(2, study.getStu_Content());
				pstmt.setDate(3, new Date(study.getStu_Date().getTime()));
				pstmt.setString(4, study.getStu_Type());
				pstmt.setString(5, study.getStu_Age());
				pstmt.setString(6, study.getStu_Id());
			}
		});
	}
	public void deleteStudy(final Study study) {
		String sql = "delete from SM_STUDY where STU_ID=?";
		jdbc.update(sql,new PreparedStatementSetter() {
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, study.getStu_Id());
			}
		});
	}
}












