package com.st.sm.entity;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable {
	private String pro_Id;
	private String pro_Name;
	private Date pro_Date;
	private String pro_Week;
	private String pro_Class_Id;

	public String getPro_Id() {
		return pro_Id;
	}

	public void setPro_Id(String pro_Id) {
		this.pro_Id = pro_Id;
	}

	public String getPro_Name() {
		return pro_Name;
	}

	public void setPro_Name(String pro_Name) {
		this.pro_Name = pro_Name;
	}

	public Date getPro_Date() {
		return pro_Date;
	}

	public void setPro_Date(Date pro_Date) {
		this.pro_Date = pro_Date;
	}

	public String getPro_Week() {
		return pro_Week;
	}

	public void setPro_Week(String pro_Week) {
		this.pro_Week = pro_Week;
	}

	public String getPro_Class_Id() {
		return pro_Class_Id;
	}

	public void setPro_Class_Id(String pro_Class_Id) {
		this.pro_Class_Id = pro_Class_Id;
	}

}
