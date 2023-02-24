package whilecontrol;

public class P95 {

	public static void main(String[] args) {
		System.out.println("Start ...");
		int i = 1;
		int cnt = 0;
		int sum = 0;
		while (i <= 10) {
			if (i % 2 == 0) {
				sum = sum + i;
				cnt++;
			}
			if (i == 8)
				break;
			i++;
		}
		double avg = (1.0 * sum) / cnt;

		System.out.println("End ... sum : " + sum);
		System.out.println("End ... avg : " + avg);
		System.out.println("End ... cnt : " + cnt);
	}

}
