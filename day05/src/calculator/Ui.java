package calculator;

public class Ui {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		int result = cal.sum(10, 20);
		System.out.println(result);

		cal.save(result);
		System.out.println("OK");
	}

}
