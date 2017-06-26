package com.st.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.sm.entity.SmClass;
import com.st.sm.service.SmClassService;

@Controller
@RequestMapping("/smclassCon")
public class SmClassController {
	@Autowired
	private SmClassService smclassservice;
	
	@RequestMapping("getAll")
	@ResponseBody
	public List<SmClass> getAll(){
		return smclassservice.getAll();
	}
	
	@RequestMapping("getAdd")
	@ResponseBody
	public void getAdd(SmClass smclass){
		smclassservice.getAdd(smclass);
	}
	
	@RequestMapping("getUpdate")
	public void getUpdate(SmClass smclass){
		smclassservice.getUpdate(smclass);
	}
	@RequestMapping("getDelete")
	public void getDelete(SmClass smclass){
		smclassservice.getDelete(smclass);
	}
	
}
