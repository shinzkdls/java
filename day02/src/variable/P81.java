package variable;

import java.util.Scanner;

public class P81 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println(sc.nextInt() > 0 ? "정상" : "비정상");
//		sc.close();

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String result = a > 0 ? "정상" : "비정상";
		System.out.println(result);
		sc.close();

	}

}
