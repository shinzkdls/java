package whilecontrol;

public class P93 {

	public static void main(String[] args) {
		System.out.println("Start ...");
		int i = 1;
		int sum = 0;
		while (i <= 100) {
			sum = sum + i;
			i++;
		}
		double avg = (1.0 * sum) / (i - 1);

		System.out.println("End ... sum : " + sum);
		System.out.println("End ... avg : " + avg);
	}

}
