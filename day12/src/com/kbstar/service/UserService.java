package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.UserDAO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Msg;
import com.kbstar.frame.Notification;
import com.kbstar.frame.CRUDService;
import com.kbstar.noti.NotificationImpl;

public class UserService implements CRUDService<String, UserDTO> {

	DAO<String, UserDTO> userDao;
	Notification notification;

	public UserService() {
		userDao = new UserDAO();
		notification = new NotificationImpl();
	}

	@Override
	public void register(UserDTO v) throws Exception {
		// 비밀번호 암호화
		try {
			userDao.insert(v);
		} catch (Exception e) {
			throw new Exception("회원가입을 실패 했습니다.(EX00011)");
		}
		notification.sendEmail(v.getEmail(), Msg.registerMsg1);
		notification.sendSMS(v.getContact(), Msg.registerMsg2);

	}

	@Override
	public void remove(String k) throws Exception {
		UserDTO user = userDao.select(k);
		try {
			userDao.delete(k);
		} catch (Exception e) {
			throw new Exception("탈퇴 오류 입니다.");
		}
		notification.sendEmail(user.getEmail(), Msg.removeMsg1);
		notification.sendSMS(user.getContact(), Msg.removeMsg2);

	}

	@Override
	public void modify(UserDTO v) throws Exception {
		try {
			userDao.update(v);
		} catch (Exception e) {
			throw new Exception("수정 오류 입니다.");
		}
	}

	@Override
	public UserDTO get(String k) throws Exception {
		UserDTO obj = null;
		obj = userDao.select(k);
		return obj;
	}

	@Override
	public List<UserDTO> get() throws Exception {
		List<UserDTO> list = null;
		try {
			list = userDao.select();
		} catch (Exception e) {
			throw new Exception("조회 오류");
		}
		return list;
	}

}
