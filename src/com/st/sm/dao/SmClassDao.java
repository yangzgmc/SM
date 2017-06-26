package com.st.sm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.st.sm.entity.SmClass;

@Repository
public class SmClassDao {
	@Autowired
	private JdbcTemplate jdbc;
	//查询所有数据
	public List<SmClass> getAll(){
		String sql="select * from sm_class";
		return jdbc.query(sql, new SmClassRowMapper());
	}
	//增加数据
	public void getAdd(SmClass smclass){
		jdbc.update("insert into sm_class values(?,?,?,?)",
				new Object[]{smclass.getCl_id(),smclass.getCl_name(),smclass.getCl_address(),smclass.getCl_tc_id()});
		
	}
	
	//修改数据
	public void getUpdate(SmClass smclass){
		jdbc.update("update sm_class set CL_NAME=?,CL_ADDRESS=?,CL_TC_ID=? where CL_ID=?", 
				new Object[]{smclass.getCl_name(),smclass.getCl_address(),smclass.getCl_tc_id(),smclass.getCl_id()});
	}
	
	//删除数据
	public void getDelete(SmClass smclass){
		jdbc.update("delete from sm_class where CL_ID=?",new Object[]{smclass.getCl_id()});
	}
	
	
	public class SmClassRowMapper implements RowMapper<SmClass>{

		@Override
		public SmClass mapRow(ResultSet rs, int rowNum) throws SQLException {

				SmClass smclass = new SmClass();
				smclass.setCl_id(rs.getString("CL_ID"));
				smclass.setCl_name(rs.getString("CL_NAME"));
				smclass.setCl_tc_id(rs.getString("CL_TC_ID"));
				smclass.setCl_address(rs.getString("CL_ADDRESS"));
			return smclass;
		}
		
	}
}
