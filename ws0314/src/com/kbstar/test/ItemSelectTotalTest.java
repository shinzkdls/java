package com.kbstar.test;

import java.util.ArrayList;
import java.util.List;

import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.ItemCRUDServiceImpl;

public class ItemSelectTotalTest {

	public static void main(String[] args) {
		CRUDService<String, Item> service = new ItemCRUDServiceImpl();
		Item item = null;
		try {
			item = service.get("2023314894100");
			System.out.println(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("====================");

		List<Item> list = new ArrayList<Item>();

		try {
			list = service.get();
			if (list.size() == 0) {
				System.out.println("데이터가 없습니다.");
			} else {
				for (Item i : list) {
					System.out.println(i);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
