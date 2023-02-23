package variable;

import java.util.Scanner;

public class P82 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력해주세요");
		int score = sc.nextInt();
		String grade = score >= 90 ? "A" : (score >= 80 ? "B" : "F");
		System.out.println(grade);
	}

}
