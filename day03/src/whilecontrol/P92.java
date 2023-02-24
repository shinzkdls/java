package whilecontrol;

public class P92 {

	public static void main(String[] args) {
		// 합과 평균을 구하시오
		System.out.println("Start ...");
		int sum = 0;
		double avg = 0;
		for (int i = 1; i <= 100; i++) {
			sum = sum + i;
			avg = (double) sum / (i * 1.0); // 1.0을 곱하는 방식도 사용
		}

		System.out.println("End ... sum : " + sum);
		System.out.println("End ... avg : " + avg);
	}

}
