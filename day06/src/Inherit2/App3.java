package Inherit2;

import java.util.Date;

public class App3 {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Manager();
		Employee e3 = new Sales();

		Object obj1 = new Employee(); // JAVA에서 모든 클래스는 extends Object상태이다(클래스 옆에는 기재 생략)
		Object obj2 = new Manager();
		Object obj3 = new Date();

	}

}
