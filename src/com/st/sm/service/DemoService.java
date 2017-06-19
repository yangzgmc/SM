package com.st.sm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.sm.dao.DemoDao;

@Service
public class DemoService {

	@Autowired
	private DemoDao demodao;
	
	
	public int getAllCount(){
		return demodao.getAllCount();
	}
}
