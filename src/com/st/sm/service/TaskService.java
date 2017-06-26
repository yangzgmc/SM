package com.st.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.sm.dao.TaskDao;
import com.st.sm.entity.Task;

@Service
public class TaskService {
   @Autowired
   private TaskDao taskDao;
   public Task addTask(Task task){
	   return taskDao.addTask(task);
   }
   public Integer updateTask(Task task){
	   return taskDao.updateTask(task);
   }
   public List<Task> getAll(){
	   return taskDao.getAll();
   }
   public Integer deleteTask(String id){
	   return taskDao.deleteTask(id);
   }
   
}
