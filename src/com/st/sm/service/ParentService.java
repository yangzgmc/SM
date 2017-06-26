package com.st.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.sm.dao.ParentDao;
import com.st.sm.entity.Parent;

@Service
public class ParentService {
  @Autowired
  private ParentDao parentDao; 
  public List<Parent> getAll(){
	  return parentDao.getAll();
  }
  
  public Parent addParent(Parent parent){
	  return parentDao.addParent(parent);
  }
  
  public void updateParent(Parent parent){
	  parentDao.updateParent(parent);
  }
//  public Parent  selectParentId(String id){
//	return  parentDao.selectParentId(id);
//  }
}
