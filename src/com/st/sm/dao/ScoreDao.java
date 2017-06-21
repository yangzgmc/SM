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

import com.st.sm.entity.Score;
@Repository
public class ScoreDao {
	@Autowired
	private JdbcTemplate jdbc;
	public List<Score> getAll(){
		String sql = "select * from Sm_Score";
		return jdbc.query(sql, new ScoreRowMapper());
	}
	
	
	
	
	
	//用来查询返回结果的类
	public class ScoreRowMapper implements RowMapper<Score>{
		//这是返回结果集
		public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
			Score score = new Score();
			score.setSc_Id(rs.getString("SC_ID"));
			score.setSc_Su_Id(rs.getString("SC_SU_ID"));
			score.setSc_Date(rs.getDate("SC_DATE"));
			score.setSc_Ls_Id(rs.getString("SC_LS_ID"));
			score.setSc_Chinese(rs.getFloat("SC_CHINESE"));
			score.setSc_Math(rs.getFloat("SC_MATH"));
			score.setSc_English(rs.getFloat("SC_ENGLISH"));
			score.setSc_Politics(rs.getFloat("SC_POLITICS"));
			score.setSc_Geography(rs.getFloat("SC_GEOGRAPHY"));
			score.setSc_Biology(rs.getFloat("SC_BIOLOGY"));
			score.setSc_History(rs.getFloat("SC_HISTORY"));
			score.setSc_All(rs.getFloat("SC_ALL"));
			score.setSc_Tc_Id(rs.getString("SC_TC_ID"));
			return score;
		}
		
	}





	public void insertScore(final Score score) {
		String sql = "insert Sm_Score values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbc.update(sql, new PreparedStatementSetter(){
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, score.getSc_Id());
				pstmt.setString(2, score.getSc_Su_Id());
				pstmt.setDate(3,new Date(score.getSc_Date().getTime()));
				pstmt.setString(4, score.getSc_Ls_Id());
				pstmt.setFloat(5, score.getSc_Chinese());
				pstmt.setFloat(6, score.getSc_Math());
				pstmt.setFloat(7, score.getSc_English());
				pstmt.setFloat(8, score.getSc_Politics());
				pstmt.setFloat(9, score.getSc_Geography());
				pstmt.setFloat(10, score.getSc_Biology());
				pstmt.setFloat(11, score.getSc_History());
				pstmt.setFloat(12, score.getSc_All());
				pstmt.setString(13, score.getSc_Tc_Id());
			}
			
		});
	}





	public Score getScoreById(String sc_Id) {
		String sql = "select * from Sm_Score where SC_ID=?";
		return jdbc.queryForObject(sql, new Object[]{sc_Id}, new ScoreRowMapper());
	}





	public void updateScore(Score score) {
		String sql = "update sm_score set SC_SU_ID='STU0011',SC_DATE='2001/12/12',SC_LS_ID='',SC_CHINESE=0,SC_MATH=0,SC_ENGLISH=0,SC_POLITICS=0,SC_GEOGRAPHY=0,SC_BIOLOGY=0,SC_HISTORY=0,SC_ALL=0,SC_TC_ID='' where SC_ID='SCO00008'";
		jdbc.update(sql);
	}





	public void deleteScore(String sc_Id) {
		String sql = "delete from sm_score where Sc_Id=?";
		jdbc.update(sql,new Object[]{sc_Id});
	}
	
	
}
