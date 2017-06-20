package com.st.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.sm.dao.ScoreDao;
import com.st.sm.entity.Score;

@Service
public class ScoreServie {
	@Autowired
	private ScoreDao scoreDao;
	public List<Score> getAll(){
		return scoreDao.getAll();
	}
}
