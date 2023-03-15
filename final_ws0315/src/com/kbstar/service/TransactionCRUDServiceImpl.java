package com.kbstar.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLRecoverableException;
import java.util.ArrayList;
import java.util.List;

import com.kbstar.dao.TransactionDaoImpl;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeNumber;

public class TransactionCRUDServiceImpl implements CRUDService<String, TransactionDTO> {
	DAO<String, String, TransactionDTO> dao;

	public TransactionCRUDServiceImpl() {
		dao = new TransactionDaoImpl();
	}

	@Override
	public void register(TransactionDTO v) throws Exception {
		// 데이터 검증
		// DB 입력
		try {
			String id = MakeNumber.makeTranNum();
			v.setId(id);
			dao.insert(v);
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new Exception("장바구니ID가 중복 되었습니다.");
			} else {
				throw new Exception("시스템 장애 입니다.");
			}
		}
		// Email, SMS전송
	}

	@Override
	public void remove(String k) throws Exception {

	}

	@Override
	public void modify(TransactionDTO v) throws Exception {
	}

	@Override
	public TransactionDTO get(String k) throws Exception {
		// 데이터 검증
		// DB 입력
		TransactionDTO trn = null;
		try {
			trn = dao.select(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애 입니다.");
			} else {
				throw new Exception("해당 거래내역이 존재 하지 않습니다.");
			}
		}
		return trn;
		// Email, SMS전송
	}

	@Override
	public List<TransactionDTO> get() throws Exception {
		// 데이터 검증
		// DB 입력
		List<TransactionDTO> list = new ArrayList<TransactionDTO>();
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
