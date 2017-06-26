package com.st.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.sm.dao.TeacherDao;
import com.st.sm.entity.Teacher;

@Service
public class TeacherService {
	@Autowired
	private TeacherDao teacherdao;
	
	public List<Teacher> getAll(){
		return teacherdao.getAll();
	}
	
	public void getAdd(Teacher teacher){
		teacherdao.getAdd(teacher);
	}
	
	public void getUpdate(Teacher teacher ){
		teacherdao.getUpdate(teacher);
	}
	
	public void getDelete(Teacher teacher){
		teacherdao.getDelete(teacher);
	}  
}
