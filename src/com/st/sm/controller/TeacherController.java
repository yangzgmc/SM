package com.st.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.sm.entity.Teacher;
import com.st.sm.service.TeacherService;

@Controller
@RequestMapping("/teacherCon")
public class TeacherController {

	@Autowired
	private TeacherService teacherservice;
	
	@RequestMapping("getAll")
	@ResponseBody
	public List<Teacher> getAll(){
		return teacherservice.getAll();
	}
	
	@RequestMapping("getAdd")
	public void getAdd(Teacher teacher){
		teacherservice.getAdd(teacher);
	}
	
	@RequestMapping("getUpdate")
	public void getUpdate(Teacher teacher){
		teacherservice.getUpdate(teacher);
	}
	
	@RequestMapping("getDelete")
	public void getDelete(Teacher teacher){
		teacherservice.getDelete(teacher);
	}
	
}
