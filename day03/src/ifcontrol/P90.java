package ifcontrol;

public class P90 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		// 두가지 수의 최대 값과 최소 값을 구하시오
		int max = 0;
		int min = 0;

		max = Math.max(a, b);
		min = Math.min(a, b);

		System.out.printf("MAX : %d, MIN : %d", max, min);
	}

}
