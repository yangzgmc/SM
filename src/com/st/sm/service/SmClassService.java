package com.st.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.sm.dao.SmClassDao;
import com.st.sm.entity.SmClass;

@Service
public class SmClassService {
	@Autowired
	private SmClassDao smclassdao;
	
	public List<SmClass> getAll(){
		return smclassdao.getAll();
	}
	
	public void getAdd(SmClass smclass){
		smclassdao.getAdd(smclass);
	}
	
	public void getUpdate(SmClass smclass){
		smclassdao.getUpdate(smclass);
	}
	
	public void getDelete(SmClass smclass){
		smclassdao.getDelete(smclass);
	}
}
