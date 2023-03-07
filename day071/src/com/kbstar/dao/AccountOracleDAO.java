package com.kbstar.dao;

import com.kbstar.frame.DAO;

public class AccountOracleDAO implements DAO {

	@Override
	public void insert(Object obj) {
		System.out.println(obj);
		System.out.println("Inserted MariaDB..."); // 실제 구현단계에서 MariaDB로 변경됐을때 바꿀건 DAO뿐
	}

	@Override
	public void delete(Object obj) {
		System.out.println(obj);
		System.out.println("Deleted MariaDB..."); // 실제 구현단계에서 MariaDB로 변경됐을때 바꿀건 DAO뿐
	}

	@Override
	public void update(Object obj) {
		System.out.println(obj);
		System.out.println("Updated MariaDB..."); // 실제 구현단계에서 MariaDB로 변경됐을때 바꿀건 DAO뿐
	}

}
