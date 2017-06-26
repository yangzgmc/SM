package com.st.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.sm.dao.RecordDao;
import com.st.sm.entity.Record;

@Service
public class RecordService {
	@Autowired
	private RecordDao recordDao;
	public List<Record> getAll(){
		return recordDao.getAll();
	}
	public void insertRecord(Record record) {
		recordDao.insertRecord(record);
	}
	public void updateRecord(Record record) {
		recordDao.updateRecord(record);
	}
	public void deleteRecord(Record record) {
		recordDao.deleteRecord(record);
		
	}
}
