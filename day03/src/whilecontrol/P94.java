package whilecontrol;

public class P94 {

	public static void main(String[] args) {
		// 짝수의 합과 평균을 구하시오
		System.out.println("Start ...");
		int sum = 0;
		int cnt = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				sum = sum + i;
				cnt++;
			}
			if (i == 8) {
				break;
			}
		}
		double avg = 1.0 * sum / cnt;
		System.out.println("End ... sum : " + sum);
		System.out.println("End ... avg : " + avg);
		System.out.println("End ... cnt : " + cnt);
	}

}
