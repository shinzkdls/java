package Inherit2;

public class App2 {

	public static void main(String[] args) {
		// Manager is a Employee
		Employee e = new Manager("1000", "James", 500, 50);

		Employee[] ea = new Employee[5];
		ea[0] = new Employee("100", "james", 500);
		ea[1] = new Employee("101", "james", 500);
		ea[2] = new Manager("102", "james", 500, 50);
		ea[3] = new Manager("103", "james", 500, 50);
		ea[4] = new Sales("104", "james", 500, "seoul", 0.35);

		for (Employee em : ea) {
			System.out.println(em);
			System.out.println(em.getAnnSalary());
//			if (em instanceof Sales) { // 객체의 타입을 확인
//				Sales s = (Sales) em; // 객체를 다른 클래스로 캐스팅
//				System.out.println(s.getIncentive());
//				// ea 객체배열은 Employee를 기준으로 생성됐기때문에
//				// 자식클래스에서 선언한 getIncentive() 메소드호출을 위해서 캐스팅필요
//			}
			// 부모 클래스인 Employee에서 빈껍데기같은 getIncentive()를 구현하고 자식클래스에서 오버라이딩할 수 도있음
			System.out.println(em.getIncentive());
		}
		System.out.println("=====================================");
		TaxCal t = new TaxCal();
		double result = t.getTax(ea[3]); // getTax는 파라미터값으로 Employee를 받지만 상속에 의한 자동타입변화
		System.out.println(result);
	}
}
