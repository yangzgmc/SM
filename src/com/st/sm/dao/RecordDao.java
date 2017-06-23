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

import com.st.sm.entity.Record;

@Repository
public class RecordDao {
	@Autowired
	private JdbcTemplate jdbc;
	public List<Record> getAll(){
		String sql = "select * from SM_RECORD";
		return jdbc.query(sql, new RecordMapper());
		
	}
	public class RecordMapper implements RowMapper<Record>{

		public Record mapRow(ResultSet rs, int rowNum) throws SQLException {
			Record record = new Record();
			record.setRe_Id(rs.getString("RE_ID"));
			record.setRe_St_Id(rs.getString("RE_ST_ID"));
			record.setRe_Date(rs.getDate("RE_DATE"));
			record.setRe_Content(rs.getString("RE_CONTENT"));
			record.setRe_Type(rs.getInt("RE_TYPE"));
			record.setRe_Tc_Id(rs.getString("RE_TC_ID"));
			return record;
		}
		
	}
	public void insertRecord(final Record record) {
		String sql = "insert SM_RECORD values(?,?,?,?,?,?)";
		jdbc.update(sql,new PreparedStatementSetter() {
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, record.getRe_Id());
				pstmt.setString(2, record.getRe_St_Id());
				pstmt.setDate(3, new Date(record.getRe_Date().getTime()));
				pstmt.setString(4, record.getRe_Content());
				pstmt.setInt(5, record.getRe_Type());
				pstmt.setString(6, record.getRe_Tc_Id());
			}
		});
	}
	public void updateRecord(final Record record) {
		String sql = "update SM_RECORD set RE_ST_ID=?,RE_DATE=?,RE_CONTENT=?,RE_TYPE=?,RE_TC_ID=? where RE_ID=?";
		jdbc.update(sql,new PreparedStatementSetter() {
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, record.getRe_St_Id());
				pstmt.setDate(2, new Date(record.getRe_Date().getTime()));
				pstmt.setString(3, record.getRe_Content());
				pstmt.setInt(4, record.getRe_Type());
				pstmt.setString(5, record.getRe_Tc_Id());
				pstmt.setString(6, record.getRe_Id());
			}
		});
	}
	public void deleteRecord(final Record record) {
		String sql = "delete from SM_RECORD where RE_ID=?";
		jdbc.update(sql,new PreparedStatementSetter() {
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, record.getRe_Id());
			}
		});
	}
}
