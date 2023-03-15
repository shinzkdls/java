package com.kbstar.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLRecoverableException;
import java.util.ArrayList;
import java.util.List;

import com.kbstar.dao.AccountDaoImpl;
import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeNumber;

public class AccountCRUDServiceImpl implements CRUDService<String, AccountDTO> {

	DAO<String, String, AccountDTO> dao;

	public AccountCRUDServiceImpl() {
		dao = new AccountDaoImpl();
	}

	@Override
	public void register(AccountDTO v) throws Exception {
		// 데이터 검증
		// DB 입력
		try {
			String accno = MakeNumber.makeAccNum();
			v.setAccNo(accno);
			dao.insert(v);
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new Exception("계좌가 중복 되었습니다.");
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
				throw new Exception("해당 계좌가 존재 하지 않습니다.");
			}
		}
		// Email, SMS전송
	}

	@Override
	public void modify(AccountDTO v) throws Exception {
		// 데이터 검증
		// DB 입력
		try {
			dao.update(v);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애 입니다.");
			} else {
				throw new Exception("해당 계좌가 존재 하지 않습니다.");
			}
		}
		// Email, SMS전송
	}

	@Override
	public AccountDTO get(String k) throws Exception {
		// 데이터 검증
		// DB 입력
		AccountDTO acc = null;
		try {
			acc = dao.select(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애 입니다.");
			} else {
				throw new Exception("해당 계좌가 존재 하지 않습니다.");
			}
		}
		return acc;
		// Email, SMS전송
	}

	@Override
	public List<AccountDTO> get() throws Exception {
		// 데이터 검증
		// DB 입력
		List<AccountDTO> list = new ArrayList<AccountDTO>();
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
