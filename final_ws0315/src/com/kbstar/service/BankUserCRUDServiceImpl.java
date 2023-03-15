package com.kbstar.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLRecoverableException;
import java.util.ArrayList;
import java.util.List;

import com.kbstar.dao.BankUserDaoImpl;
import com.kbstar.dto.BankUserDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;

public class BankUserCRUDServiceImpl implements CRUDService<String, BankUserDTO> {

	DAO<String, String, BankUserDTO> dao;

	public BankUserCRUDServiceImpl() {
		dao = new BankUserDaoImpl();
	}

	@Override
	public void register(BankUserDTO v) throws Exception {
		// 데이터 검증
		// DB 입력
		try {
			dao.insert(v);
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new Exception("ID가 중복 되었습니다.");
			} else {
				throw new Exception("시스템 장애 입니다.");
			}
		}
		// Email, SMS전송
	}

	@Override
	public void remove(String k) throws Exception {
		// 데이터 검증
		// DB 입력
		try {
			dao.delete(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애 입니다.");
			} else {
				throw new Exception("해당 ID가 존재 하지 않습니다.");
			}
		}
		// Email, SMS전송
	}

	@Override
	public void modify(BankUserDTO v) throws Exception {
		// 데이터 검증
		// DB 입력
		try {
			dao.update(v);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애 입니다.");
			} else {
				throw new Exception("해당 ID가 존재 하지 않습니다.");
			}
		}
		// Email, SMS전송
	}

	@Override
	public BankUserDTO get(String k) throws Exception {
		// 데이터 검증
		// DB 입력
		BankUserDTO cust = null;
		try {
			cust = dao.select(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애 입니다.");
			} else {
				throw new Exception("해당 ID가 존재 하지 않습니다.");
			}
		}
		return cust;
		// Email, SMS전송
	}

	@Override
	public List<BankUserDTO> get() throws Exception {
		// 데이터 검증
		// DB 입력
		List<BankUserDTO> list = new ArrayList<BankUserDTO>();
		try {
			list = dao.selectAll();
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애 입니다.");
			} else {
				throw new Exception("데이터가 존재 하지 않습니다.");
			}
		}
		return list;
	}

}
