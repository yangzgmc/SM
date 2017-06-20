package com.st.sm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
}
