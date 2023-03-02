package com.kbstar.hrd.app;

import com.kbstar.hrd.Manager;

public class App2 {

	public static void main(String[] args) {
		Manager m = new Manager("100", "이말숙", 500, 100);
		System.out.println(m); // e.toString과 동일하게 동작함
		System.out.println(m.getSalary());
		System.out.println(m.getTax());
		System.out.println(m.getAnnSalary());
		System.out.println(m.getAnnTax());
		System.out.println("=======================================");

		Manager[] mags = new Manager[3];
		mags[0] = new Manager("301", "정수아", 500, 50);
		mags[1] = new Manager("302", "이수아", 510, 55);
		mags[2] = new Manager("303", "고수아", 520, 65);

		for (Manager ma : mags) {
			System.out.println(ma);
			System.out.println(ma.getAnnSalary());
			System.out.println(ma.getTax());
			System.out.println(ma.getAnnTax());
			System.out.println("");
		}
	}

}
