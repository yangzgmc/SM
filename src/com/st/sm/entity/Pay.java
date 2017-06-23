package com.st.sm.entity;

import java.util.Date;

public class Pay {
	private String pay_Id;
	private String pay_St_Id;
	private Date pay_Date;
	private String pay_Remarks;
	private float pay_Type;
	private String pay_Tc_Id;
	public String getPay_Id() {
		return pay_Id;
	}
	public void setPay_Id(String pay_Id) {
		this.pay_Id = pay_Id;
	}
	public String getPay_St_Id() {
		return pay_St_Id;
	}
	public void setPay_St_Id(String pay_St_Id) {
		this.pay_St_Id = pay_St_Id;
	}
	public Date getPay_Date() {
		return pay_Date;
	}
	public void setPay_Date(Date pay_Date) {
		this.pay_Date = pay_Date;
	}
	public String getPay_Remarks() {
		return pay_Remarks;
	}
	public void setPay_Remarks(String pay_Remarks) {
		this.pay_Remarks = pay_Remarks;
	}
	public float getPay_Type() {
		return pay_Type;
	}
	public void setPay_Type(float pay_Type) {
		this.pay_Type = pay_Type;
	}
	public String getPay_Tc_Id() {
		return pay_Tc_Id;
	}
	public void setPay_Tc_Id(String pay_Tc_Id) {
		this.pay_Tc_Id = pay_Tc_Id;
	}
	
}	
