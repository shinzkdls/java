package com.kbstar.service;

import com.kbstar.dao.UserDAO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Service;

public class UserService implements Service<String, UserDTO> {

	DAO<String, UserDTO> dao;

	public UserService() {
		dao = new UserDAO();
	}

	@Override
	public void register(UserDTO v) throws Exception {
		System.out.println("Security Check..");
		try {
			dao.insert(v);
		} catch (Exception e) {
			// 이 영역에서 로그를 남기는 작업 가능
			throw e;
		}
		System.out.println("Send mail..");
		System.out.println("Send SMS..");
	}

	@Override
	public void remove(String k) throws Exception {
		try {
			dao.delete(k);
		} catch (Exception e) {
			// 이 영역에서 로그를 남기는 작업 가능
			throw e;
		}
		System.out.println("Send SMS..");
	}

	@Override
	public void modify(UserDTO v) throws Exception {
		try {
			dao.update(v);
		} catch (Exception e) {
			// 이 영역에서 로그를 남기는 작업 가능
			throw e;
		}
		System.out.println("Send SMS..");
	}

}
