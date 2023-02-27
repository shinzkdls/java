package array;

import java.util.Arrays;
import java.util.Random;

public class P105 {

	public static void main(String[] args) {
		int arr[] = new int[5];
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(9) + 1;
		}

		System.out.println(Arrays.toString(arr));

		// 배열의 합과 평균을 구하시오
		// 홀수번째의 합과 평균을 구하시오
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				sum = sum + arr[i];
				cnt++;
			}
		}
		double avg = (1.0 * sum) / cnt;
		System.out.println("배열의 홀수번째 합: " + sum);
		System.out.println("배열의 홀수번째 평균: " + avg);
	}

}
