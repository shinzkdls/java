package array;

import java.util.Arrays;
import java.util.Random;

public class P106 {

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
		// 배열의 홀수의 값들의 합과 평균을 구하시오
		int sum = 0;
		int cnt = 0;
		for (int data : arr) {
			if (data % 2 == 1) {
				sum = sum + data;
				cnt++;
			}
		}
		double avg = (1.0 * sum) / cnt;
		System.out.println("배열의 홀수값 합: " + sum);
		System.out.println("배열의 홀수값 평균: " + avg);

	}

}
