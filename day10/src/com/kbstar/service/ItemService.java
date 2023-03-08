package com.kbstar.service;

import com.kbstar.dao.ItemDAO;
import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.SearchService;
import com.kbstar.frame.Service;

public class ItemService implements Service<Integer, ItemDTO>, SearchService {

	DAO<Integer, ItemDTO> dao;

	public ItemService() {
		dao = new ItemDAO();
	}

	@Override
	public void register(ItemDTO v) throws Exception {
		System.out.println(v + " Data check...");
		try {
			dao.insert(v);
		} catch (Exception e) {
			// 이 영역에서 로그를 남기는 작업 가능
			throw e;
		}
		System.out.println("Send SMS...");
	}

	@Override
	public void remove(Integer k) throws Exception {
		System.out.println(k + " Data check...");
		try {
			dao.delete(k);
		} catch (Exception e) {
			// 이 영역에서 로그를 남기는 작업 가능
			throw e;
		}
		System.out.println("Send SMS...");
	}

	@Override
	public void modify(ItemDTO v) throws Exception {
		System.out.println(v + " Data check...");
		try {
			dao.update(v);
		} catch (Exception e) {
			// 이 영역에서 로그를 남기는 작업 가능
			throw e;
		}
		System.out.println("Send SMS...");
	}

	@Override
	public void search() {
		System.out.println("Item search...");
	}

}
