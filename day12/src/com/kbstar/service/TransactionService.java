package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.TransactionDAO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Notification;
import com.kbstar.noti.NotificationImpl;

public class TransactionService implements CRUDService<String, TransactionDTO> {

	DAO<String, TransactionDTO> trnDao;
	Notification notification;

	public TransactionService() {
		trnDao = new TransactionDAO();
		notification = new NotificationImpl();
	}

	@Override
	public void register(TransactionDTO v) throws Exception {
		trnDao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		trnDao.delete(k);
	}

	@Override
	public void modify(TransactionDTO v) throws Exception {
		trnDao.update(v);
	}

	@Override
	public TransactionDTO get(String k) throws Exception {
		TransactionDTO obj = null;
		obj = trnDao.select(k);
		return obj;
	}

	@Override
	public List<TransactionDTO> get() throws Exception {
		List<TransactionDTO> list = null;
		list = trnDao.select();
		return list;
	}

}
