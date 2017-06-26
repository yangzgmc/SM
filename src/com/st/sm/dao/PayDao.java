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

import com.st.sm.entity.Pay;

@Repository
public class PayDao {
	@Autowired
	private JdbcTemplate jdbc;
	public List<Pay> getAll(){
		String sql = "select * from SM_PAY";
		return jdbc.query(sql, new PayRowMapper());
	}
	
	public class PayRowMapper implements RowMapper<Pay>{

		public Pay mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pay pay = new Pay();
			pay.setPay_Id(rs.getString("PAY_ID"));
			pay.setPay_St_Id(rs.getString("PAY_ST_ID"));
			pay.setPay_Date(rs.getDate("PAY_DATE"));
			pay.setPay_Remarks(rs.getString("PAY_REMARKS"));
			pay.setPay_Type(rs.getFloat("PAY_TYPE"));
			pay.setPay_Tc_Id(rs.getString("PAY_TC_ID"));
			return pay;
		}
		
	}

	public void insertPay(final Pay pay) {
		String sql = "insert SM_PAY values(?,?,?,?,?,?)";
		jdbc.update(sql,new PreparedStatementSetter() {
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, pay.getPay_Id());
				pstmt.setString(2, pay.getPay_St_Id());
				pstmt.setDate(3, new Date(pay.getPay_Date().getTime()));
				pstmt.setString(4, pay.getPay_Remarks());
				pstmt.setFloat(5, pay.getPay_Type());
				pstmt.setString(6, pay.getPay_Tc_Id());
			}
		});
	}

	public void updatePay(final Pay pay) {
		String sql = "update SM_PAY set PAY_ST_ID=?,PAY_DATE=?,PAY_REMARKS=?,PAY_TYPE=?,PAY_TC_ID=? where PAY_ID=?";
		jdbc.update(sql,new PreparedStatementSetter() {
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, pay.getPay_St_Id());
				pstmt.setDate(2, new Date(pay.getPay_Date().getTime()));
				pstmt.setString(3, pay.getPay_Remarks());
				pstmt.setFloat(4, pay.getPay_Type());
				pstmt.setString(5, pay.getPay_Tc_Id());
				pstmt.setString(6, pay.getPay_Id());
			}
		});
	}

	public void deletePay(final Pay pay) {
		String sql = "delete from SM_PAY where PAY_ID=?";
		jdbc.update(sql,new PreparedStatementSetter() {
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, pay.getPay_Id());
			}
		});
	}
}
