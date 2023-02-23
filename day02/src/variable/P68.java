package variable;

import java.util.Random;

public class P68 {

	public static void main(String[] args) {
		String s2 = "11";
		String s1 = "10";
		int s2 = Integer.parseInt(s1);
		int a = 10;
		System.out.println(s1 + a);
		System.out.println(s2 + a);

		Random r = new Random();
		int randomNumber = r.nextInt(10); // 0~9까지 정수형 랜덤
		System.out.println(randomNumber);

	}

}
