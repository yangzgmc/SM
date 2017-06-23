package com.st.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.sm.dao.StudyDao;
import com.st.sm.entity.Study;

@Service
public class StudyService {
	@Autowired
	private StudyDao studyDao;
	public List<Study> getAll(){
		return studyDao.getAll();
	}
	public void insertStudy(Study study) {
		studyDao.insertStudy(study);
	}
	public void updateStudy(Study study) {
		studyDao.updateStudy(study);
	}
	public void deleteStudy(Study study) {
		studyDao.deleteStudy(study);
	}
}
