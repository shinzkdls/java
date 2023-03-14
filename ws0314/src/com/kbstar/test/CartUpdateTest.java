package com.kbstar.test;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartUpdateTest {

	public static void main(String[] args) {
		CRUDService<String, Cart> service = new CartCRUDServiceImpl();

		Cart cart = new Cart("2023314861100", "id77", "2023317777777", 7, null);
		try {
			service.modify(cart);
			System.out.println("성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}