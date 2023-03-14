package com.kbstar.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLRecoverableException;
import java.util.ArrayList;
import java.util.List;

import com.kbstar.dao.CartDaoImpl;
import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeItemNumber;

public class CartCRUDServiceImpl implements CRUDService<String, Cart> {
	DAO<String, String, Cart> dao;

	public CartCRUDServiceImpl() {
		dao = new CartDaoImpl();
	}

	@Override
	public void register(Cart v) throws Exception {
		// 데이터 검증
		// DB 입력
		try {
			String id = MakeItemNumber.makeCartNum();
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
		// 데이터 검증
		// DB 입력
		try {
			dao.delete(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애 입니다.");
			} else {
				throw new Exception("해당 장바구니ID가 존재 하지 않습니다.");
			}
		}
		// Email, SMS전송

	}

	@Override
	public void modify(Cart v) throws Exception {
		// 데이터 검증
		// DB 입력
		try {
			dao.update(v);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애 입니다.");
			} else {
				throw new Exception("해당 장바구니 내역이 존재 하지 않습니다.");
			}
		}
		// Email, SMS전송
	}

	@Override
	public Cart get(String k) throws Exception {
		// 데이터 검증
		// DB 입력
		Cart cart = null;
		try {
			cart = dao.select(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애 입니다.");
			} else {
				throw new Exception("해당 장바구니 내역이 존재 하지 않습니다.");
			}
		}
		return cart;
		// Email, SMS전송
	}

	@Override
	public List<Cart> get() throws Exception {
		// 데이터 검증
		// DB 입력
		List<Cart> list = new ArrayList<Cart>();
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
