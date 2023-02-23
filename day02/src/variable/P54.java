package variable;

public class P54 {

	public static void main(String[] args) {
		// boolean
		boolean b1 = 10 > 5;

		// 정수
		int n1 = 10;
		long n2 = 0L; // 정수의 디폴트값은 int이기 때문에 숫자뒤에 L을 붙여 타입변환
		n2 = 222222222222222L;

		// 실수
		double d1 = 1.0;
		float f1 = 1.0F;

		double d2 = 1 / 2;
		System.out.println(d2);

		double d3 = 10.0 / 3.0;
		System.out.println(d3);

		float f2 = 10.0F / 3.0F;
		System.out.println(f2);

		// char
		char c1 = 'A';
		System.out.println(c1);

		char c2 = 65;
		System.out.println(c2);

		int n3 = 10;
		double n4 = 10.0;
		double result = n3 + n4;
		System.out.println(result);

	}

}
