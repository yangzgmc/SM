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
	public void insertScore(Score score) {
		scoreDao.insertScore(score);
	}
	public Score getScoreById(String sc_Id) {
		Score score = scoreDao.getScoreById(sc_Id);
		return score;
	}
	public void updateScore(Score score) {
		scoreDao.updateScore(score);
	}
	public void deleteScore(String sc_Id) {
		scoreDao.deleteScore(sc_Id);
	}
}
