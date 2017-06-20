package com.st.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.sm.entity.Score;
import com.st.sm.service.ScoreServie;

@Controller
@RequestMapping("/scoreCon")
public class ScoreController {
	@Autowired
	private ScoreServie scoreService;
	@RequestMapping("getAll")
	@ResponseBody
	public List<Score> getAll(){
		return scoreService.getAll();
	}
}
