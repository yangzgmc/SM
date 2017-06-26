package com.st.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.st.sm.entity.Project;
import com.st.sm.service.ProjectService;

@Controller
@RequestMapping("/projectCon")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@RequestMapping("deleteProject")
	@ResponseBody
	public Integer deleteProject(String id){
		return projectService.deleteProject(id);
	}
	
	@RequestMapping("getAll")
	@ResponseBody
    public List<Project> getAll(){
    	return projectService.getAll();
    }
	@RequestMapping("addProject")
	@ResponseBody
    public Project addProject(Project project){
    	return projectService.addProject(project);
	}
	@RequestMapping("updateProject")
	@ResponseBody
    public Integer updateProject(Project project){
    	 return projectService.updateProject(project);
	}
 
}
