package com.st.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping("insertScore")
	public void insertScore(Score score){
		System.out.println("hhhhhhhhhhh");
		scoreService.insertScore(score);
	}
	//跳转添加页面
	@RequestMapping("toAddScore")
	public String toAddScore(){
		return "addScore";
	}
	
	//跳转修改页面
	/*@RequestMapping("toUpdateScore")
	public String toUpdateScore(){
		return "redirect:/WEB-INF/updateScore.html";
	}*/
	
	//回显学生成绩
	@RequestMapping("getScoreById")
	@ResponseBody
	public Score getScoreById(String Sc_Id,Model model){ 
		Score score = scoreService.getScoreById(Sc_Id); 
		return score;
	}
	//修改学生成绩
	@RequestMapping("updateScore")
	public void updateScore(Score score){
		scoreService.updateScore(score);
	}
	
	//删除学生成绩
	@RequestMapping("deleteScore")
	public void deleteScore(String Sc_Id){
		scoreService.deleteScore(Sc_Id);
	}
	
	
	
	
	
}
