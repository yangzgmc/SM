package com.st.sm.entity;

import java.io.Serializable;

public class Task implements Serializable {
	private String tk_Id;
	private String tk_Class_Id;
	private String tk_Project_Id;
	private String tk_Content;

	public String getTk_Id() {
		return tk_Id;
	}

	public void setTk_Id(String tk_Id) {
		this.tk_Id = tk_Id;
	}

	public String getTk_Class_Id() {
		return tk_Class_Id;
	}

	public void setTk_Class_Id(String tk_Class_Id) {
		this.tk_Class_Id = tk_Class_Id;
	}

	public String getTk_Project_Id() {
		return tk_Project_Id;
	}

	public void setTk_Project_Id(String tk_Project_Id) {
		this.tk_Project_Id = tk_Project_Id;
	}

	public String getTk_Content() {
		return tk_Content;
	}

	public void setTk_Content(String tk_Content) {
		this.tk_Content = tk_Content;
	}

}
