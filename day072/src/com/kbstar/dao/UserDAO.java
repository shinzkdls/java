package com.kbstar.dao;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;

public class UserDAO implements DAO<String, UserDTO, Integer> {
	// 제네릭을 통해 선언한 K, V를 실제 구현 DAO에서 입력 타입값 선언

	@Override
	public void insert(UserDTO v) {
		System.out.println(v.getId() + "님이 저장 되었습니다.");
	}

	@Override
	public void delete(String k) {
		System.out.println(k + "님이 삭제 되었습니다.");
	}

	@Override
	public void update(UserDTO v) {
		System.out.println(v.getId() + "님의 정보가 수정 되었습니다.");
	}

}
