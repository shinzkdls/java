package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.Cust;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustCRUDServiceImpl;

public class CustSelectTest {

	public static void main(String[] args) {
		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();
		Cust cust = null;
		try {
			cust = crudService.get("id78");
			System.out.println(cust);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("====================");

		List<Cust> list = null;

		try {
			list = crudService.get();
			for (Cust c : list) {
				System.out.println(c);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
