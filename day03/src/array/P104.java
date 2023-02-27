package array;

import java.util.Arrays;
import java.util.Random;

public class P104 {

	public static void main(String[] args) {
		int arr[] = new int[10];
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(99) + 1;
		}
		for (int a : arr) {
			System.out.printf("%d \t", a);
		}
		System.out.println("");
		System.out.println(Arrays.toString(arr));

		// 배열의 합과 평균을 구하시오
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		double avg = 1.0 * sum / arr.length;
		System.out.println("배열의 합: " + sum);
		System.out.println("배열의 평균: " + avg);
	}

}
