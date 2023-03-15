package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.frame.ShopService;
import com.kbstar.service.ShopServiceImpl;

public class myCartSelectAllTest {

	public static void main(String[] args) throws Exception {
		// CRUDService<String, Cart> service = new CartCRUDServiceImpl();
		ShopService<Cust, Cart> shopService = new ShopServiceImpl();

		List<Cart> list = null;
		try {
			list = shopService.myCart("id01");
			if (list.size() == 0) {
				System.out.println("데이터가 없습니다.");
			} else {
				for (Cart c : list) {
					System.out.println(c);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}