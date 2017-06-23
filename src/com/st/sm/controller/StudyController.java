package com.st.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.sm.entity.Study;
import com.st.sm.service.StudyService;

@Controller
@RequestMapping("/studyCon")
public class StudyController {
	@Autowired
	private StudyService studyService;
	@RequestMapping("getAll")
	@ResponseBody
	private List<Study> getAll(){
		return studyService.getAll();
	}
	
	@RequestMapping("insertStudy")
	public void insertStudy(Study study){
		studyService.insertStudy(study);
	}
	
	@RequestMapping("updateStudy")
	public void updateStudy(Study study){
		studyService.updateStudy(study);
	}
	
	@RequestMapping("deleteStudy")
	public void deleteStudy(Study study){
		studyService.deleteStudy(study);
	}
	
	
	
	
	
	
}
