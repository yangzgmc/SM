package com.st.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.sm.dao.ListDao;
import com.st.sm.entity.List1;

@Service
public class ListService {
	@Autowired
	private ListDao listDao;
	public List<List1> getAll(){
		return listDao.getAll();
	}
	public void insertList(List1 list) {
		listDao.insertList(list);
	}
	
	public void updateList(List1 list) {
		listDao.updateList(list);
	}
	public void deleteList(List1 list) {
		listDao.deleteList(list);
	}
}
