package com.st.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.sm.entity.Pay;
import com.st.sm.service.PayService;

@Controller
@RequestMapping("payCon")
public class PayController {
	@Autowired
	private PayService payService;
	@RequestMapping("getAll")
	@ResponseBody
	public List<Pay> getAll(){
		return payService.getAll();
	}
	@RequestMapping("insertPay")
	public void insertPay(Pay pay){ 
		payService.insertPay(pay);
	}
	@RequestMapping("updatePay")
	public void updatePay(Pay pay){ 
		payService.updatePay(pay); 
	}
	@RequestMapping("deletePay")
	public void deletePay(Pay pay){ 
		payService.deletePay(pay); 
	}
	
	
}




























