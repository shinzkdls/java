package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.ItemCRUDServiceImpl;

public class ItemSelectAllTest {

	public static void main(String[] args) throws Exception {
		CRUDService<String, Item> crudService = new ItemCRUDServiceImpl();

		List<Item> list = null;
		try {
			list = crudService.get();
			if (list.size() == 0) {
				System.out.println("데이터가 없습니다.");
			} else {
				for (Item obj : list) {
					System.out.println(obj);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}