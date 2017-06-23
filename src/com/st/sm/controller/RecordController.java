package com.st.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.sm.entity.Record;
import com.st.sm.service.RecordService;

@Controller
@RequestMapping("/recordCon")
public class RecordController {
	@Autowired
	private RecordService recordService;
	@RequestMapping("getAll")
	@ResponseBody
	public List<Record> getAll(){
		return recordService.getAll();
	}
	@RequestMapping("insertRecord")
	public void insertRecord(Record record){
		recordService.insertRecord(record);
	}
	@RequestMapping("updateRecord")
	public void updateRecord(Record record){
		recordService.updateRecord(record); 
	}
	@RequestMapping("deleteRecord")
	public void deleteRecord(Record record){
		recordService.deleteRecord(record); 
	}
}



















