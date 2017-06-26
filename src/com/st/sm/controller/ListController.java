package com.st.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.sm.entity.List1;
import com.st.sm.service.ListService;

@Controller
@RequestMapping("/listCon")
public class ListController {
	@Autowired
	private ListService listService;
	@RequestMapping("getAll")
	@ResponseBody
	public List<List1> getAll(){
		return listService.getAll();
	}
	
	@RequestMapping("insertList")
	public void insertList(List1 list){
		listService.insertList(list);
	}
	
	@RequestMapping("updateList")
	public void updateList(List1 list){
		listService.updateList(list);
	}
	
	@RequestMapping("deleteList")
	public void deleteList(List1 list){
		listService.deleteList(list);
	}
	
	
	
}
