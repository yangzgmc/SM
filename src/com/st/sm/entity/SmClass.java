package com.st.sm.entity;
/**
 * 班级
 * @author 不知不觉
 *
 */
public class SmClass {
	private String cl_id; //编号
	private String cl_name;	//班级名称
	private String cl_address;	//班级位置
	private String cl_tc_id; //班主任
	public String getCl_id() {
		return cl_id;
	}
	public void setCl_id(String cl_id) {
		this.cl_id = cl_id;
	}
	public String getCl_name() {
		return cl_name;
	}
	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}
	
	public String getCl_address() {
		return cl_address;
	}
	public void setCl_address(String cl_address) {
		this.cl_address = cl_address;
	}
	public String getCl_tc_id() {
		return cl_tc_id;
	}
	public void setCl_tc_id(String cl_tc_id) {
		this.cl_tc_id = cl_tc_id;
	}
	
}
