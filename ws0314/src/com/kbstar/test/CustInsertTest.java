package com.kbstar.test;

import com.kbstar.dto.Cust;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustCRUDServiceImpl;

public class CustInsertTest {

	public static void main(String[] args) {
		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();
		Cust cust = new Cust("id79", "pwd20", "tom", 37);
		Cust cust2 = new Cust("id78", "pwd20", "tom", 35);
		try {
			crudService.register(cust);
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
