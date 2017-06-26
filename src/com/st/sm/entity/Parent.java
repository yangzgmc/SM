package com.st.sm.entity;

import java.io.Serializable;

public class Parent implements Serializable {
	private String pa_Id;
	private String st_Id;
	private String pa_Name;
	private Integer pa_Type;
	private String pa_Phone;
	public String getPa_Id() {
		return pa_Id;
	}
	public void setPa_Id(String pa_Id) {
		this.pa_Id = pa_Id;
	}
	public String getSt_Id() {
		return st_Id;
	}
	public void setSt_Id(String st_Id) {
		this.st_Id = st_Id;
	}
	public String getPa_Name() {
		return pa_Name;
	}
	public void setPa_Name(String pa_Name) {
		this.pa_Name = pa_Name;
	}
	public Integer getPa_Type() {
		return pa_Type;
	}
	public void setPa_Type(Integer pa_Type) {
		this.pa_Type = pa_Type;
	}
	public String getPa_Phone() {
		return pa_Phone;
	}
	public void setPa_Phone(String pa_Phone) {
		this.pa_Phone = pa_Phone;
	}
	


}
