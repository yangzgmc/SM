package com.st.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.sm.dao.StudentDao;
import com.st.sm.entity.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentdao;
	
	public List<Student> getAll(){
		return studentdao.getAll();
	}
	
	public void getAdd(Student st){
		studentdao.getAdd(st);
	}
	
	public void getUpdate(Student st){
		studentdao.getUpdate(st);
	}
	
	public void getDelete(Student st){
		studentdao.getDelete(st);
	}
}
