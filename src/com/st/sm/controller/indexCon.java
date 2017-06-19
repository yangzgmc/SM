package com.st.sm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexCon {
	@RequestMapping("index")
	public String index(){
		System.out.println("已经入中小学生管理系统...");
		return "index";
	}
}
