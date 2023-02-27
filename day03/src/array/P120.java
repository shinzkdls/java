package array;

public class P120 {

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++)
			a[i] = i + 1;

		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		double avg = (1.0 * sum) / a.length;

		System.out.println("배열의 합: " + sum);
		System.out.println("배열의 평균: " + avg);
	}

}
