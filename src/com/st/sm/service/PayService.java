package com.st.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.sm.dao.PayDao;
import com.st.sm.entity.Pay;

@Service
public class PayService { 
	@Autowired
	private PayDao payDao;
	
	public List<Pay> getAll(){
		return payDao.getAll();
	}

	public void insertPay(Pay pay) {
		payDao.insertPay(pay);
	}

	public void updatePay(Pay pay) {
		payDao.updatePay(pay);
	}

	public void deletePay(Pay pay) {
		payDao.deletePay(pay);
	}
}
