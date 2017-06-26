package com.st.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.sm.entity.Student;
import com.st.sm.service.StudentService;

@Controller
@RequestMapping("/studentCon")
public class StudentController {
	@Autowired
	private StudentService studentservice;
	
	@RequestMapping("getAll")
	@ResponseBody
	public List<Student> getAll(){
		return studentservice.getAll();
	}
	
	@RequestMapping("getAdd")
	public void getAdd(Student st){
		studentservice.getAdd(st);
	}
	
	@RequestMapping("getUpdate")
	public void getUpdate(Student st){
		studentservice.getUpdate(st);
	}
	
	@RequestMapping("getDelete")
	public void getDelete(Student st){
		studentservice.getDelete(st);
	}
}
