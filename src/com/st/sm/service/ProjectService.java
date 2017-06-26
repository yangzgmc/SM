package com.st.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.sm.dao.ProjectDao;
import com.st.sm.entity.Project;

@Service
public class ProjectService {
  @Autowired
   private ProjectDao projectDao;
  
   public Integer deleteProject(String id ){
	   return projectDao.deleteProject(id);
   }
   
   public List<Project> getAll(){
		  return projectDao.getAll();
	  
   }
	  
	  
   public Project addProject(Project project){
		  return projectDao.addProject(project);
	 
   }
   public Integer updateProject(Project project){
		 return  projectDao.updatePorject(project);
	 
}
	 
  
}
