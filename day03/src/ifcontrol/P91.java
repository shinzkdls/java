package ifcontrol;

public class P91 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = 15;
		// 세가지 수의 최대 값과 최소 값을 구하시오
		int max = 0;
		int min = 0;

		max = a > b ? (a > c ? a : c) : (b > c ? b : c);
		min = a < b ? (a < c ? a : c) : (b < c ? b : c);

//		if (a > b) {
//			if (a > c) {
//				max = a;
//				if (b > c)
//					min = c;
//				else
//					min = b;
//			} else {
//				max = c;
//				min = b;
//			}
//		} else {
//			if (b > c) {
//				max = b;
//				if (a > c)
//					min = c;
//				else
//					min = a;
//			} else {
//				max = c;
//				min = a;
//			}
//		}

		max = Math.max(a, Math.max(b, c));
		min = Math.min(a, Math.min(b, c));

		System.out.printf("MAX : %d, MIN : %d", max, min);
	}

}
