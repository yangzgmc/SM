package com.st.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.sm.entity.Task;
import com.st.sm.service.TaskService;

@Controller
@RequestMapping("/taskCon")
public class TaskController {
  @Autowired
  private TaskService taskService;
  @RequestMapping("addTask")
  @ResponseBody
  public Task addTask(Task task){
	  return taskService.addTask(task);
  }
  @RequestMapping("updateTask")
  @ResponseBody
  public Integer  updateTask(Task task){
	   return taskService.updateTask(task);
  }
  @RequestMapping("getAll")
  @ResponseBody
  public List<Task> getAll(){
	   return taskService.getAll();
  }
  @RequestMapping("deleteTask")
  @ResponseBody
  public Integer deleteTask(String id){
	   return taskService.deleteTask(id);
  }
}
