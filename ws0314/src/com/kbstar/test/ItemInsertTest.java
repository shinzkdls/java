
package com.kbstar.test;

import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.ItemCRUDServiceImpl;

public class ItemInsertTest {

	public static void main(String[] args) {
		CRUDService<String, Item> service = new ItemCRUDServiceImpl();
		Item obj = new Item("pants2", 20000, 3.2);
		try {
			service.register(obj);
			System.out.println("성공1");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
//		try {
//			crudService.remove("id79");
//			System.out.println("성공2");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//			crudService.modify(cust2);
//			System.out.println("성공3");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

	}

}