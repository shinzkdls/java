
package com.kbstar.test;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartInsertTest {

	public static void main(String[] args) {
		CRUDService<String, Cart> service = new CartCRUDServiceImpl();
		Cart cart = new Cart("id02", "2023314894100", 33);
		try {
			service.register(cart);
			System.out.println("성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}