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

import com.st.sm.entity.News;


@Repository
public class NewsDao {
	@Autowired
    private JdbcTemplate jdbc;
    
    //增加 新闻
    public News addNews(News news){
		String sql="insert into sm_news value(?,?,?,?,?)";
		Object[] params=new Object[]{news.getNews_Id(),news.getNews_Date(),news.getNews_Title(),news.getNews_Content(),news.getNews_Image()};
		int[] types=new int[]{Types.VARCHAR,Types.DATE,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
		 jdbc.update(sql,params,types);
		 return news;
		
	}
    //修改 新闻
    public Integer updateNews(final News news){
   	String sql="update sm_news set NEWS_DATE=?,NEWS_TITLE=?,NEWS_CONTENT=?,NEWS_IMAGE=? where NEWS_ID=?";
    return	jdbc.update(sql,new PreparedStatementSetter() {
		
		@Override
		public void setValues(PreparedStatement  pstmt) throws SQLException {
          	pstmt.setDate(1, new Date(news.getNews_Date().getTime()));
          	pstmt.setString(2, news.getNews_Title());
          	pstmt.setString(3, news.getNews_Content());
          	pstmt.setString(4, news.getNews_Image());
          	pstmt.setString(5, news.getNews_Id());
          			
		}
	});
    }
    //查询 新闻
    public List<News> getAll(){
    	String sql="select * from sm_news";
    	 return jdbc.query(sql,new NewsRowMapper());
    }
    public class NewsRowMapper implements RowMapper<News>{

		@Override
		public News mapRow(ResultSet rs, int rownum) throws SQLException {
			News news=new News();
			news.setNews_Id(rs.getString("NEWS_ID"));
			news.setNews_Date(rs.getDate("NEWS_DATE"));
			news.setNews_Title(rs.getString("NEWS_TITLE"));
			news.setNews_Content(rs.getString("NEWS_CONTENT"));
			news.setNews_Image(rs.getString("NEWS_IMAGE"));
	       return news;
		}
    	
    }
    //删除 新闻
    public Integer deleteNews(String id){
    	String sql="delete from sm_news where News_ID=?";
    	 return jdbc.update(sql,id);
    }
}
