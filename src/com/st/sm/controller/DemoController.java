package com.st.sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.sm.service.DemoService;

@Controller
@RequestMapping("/demoCon")
public class DemoController {

	@Autowired
	private DemoService demoSer;
	
	@RequestMapping("getCon")
	@ResponseBody
	public int  getAllCount(){
		System.out.println("getCont .....:"+demoSer.getAllCount());
		
		return demoSer.getAllCount();
	}
}
