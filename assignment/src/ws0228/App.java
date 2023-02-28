package ws0228;

public class App {

	public static void main(String[] args) {
		Employee[] arrEmp = { new Employee("0001", "Emp1", 1000000), new Employee("0002", "Emp2", 1100000),
				new Employee("0003", "Emp3", 1200000), new Employee("0004", "Emp4", 1300000),
				new Employee("0005", "Emp5", 1400000) };
		Manager[] arrMag = { new Manager("1001", "Mag1", 2000000, 200000), new Manager("1002", "Mag2", 2100000, 210000),
				new Manager("1003", "Mag3", 2200000, 220000), new Manager("1004", "Mag4", 2300000, 230000),
				new Manager("1005", "Mag5", 2400000, 240000) };

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == 0) {
					System.out.println(arrEmp[j].toString());
				} else {
					System.out.println(arrMag[j].toString());
				}
			}
			System.out.println("");
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == 0) {
					System.out.println(arrEmp[j].getName() + "의 연봉: " + arrEmp[j].getAnnSalary() + ", 세금: "
							+ Math.round(arrEmp[j].getTax()));
				} else {
					System.out.println(arrMag[j].getName() + "의 연봉: " + arrMag[j].getAnnSalary() + ", 세금: "
							+ Math.round(arrMag[j].getTax()));
				}
			}
			System.out.println("");
		}

		for (int i = 0; i < 2; i++) {
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				if (i == 0) {
					sum = sum + arrEmp[j].getAnnSalary();
				} else {
					sum = sum + arrMag[j].getAnnSalary();
				}
			}
			if (i == 0) {
				System.out.println("Employee의 연봉 합계: " + sum);
			} else {
				System.out.println("Manager의 연봉 합계: " + sum);
			}
			System.out.println("");
		}

	}

}
