package variable;

import java.util.Scanner;

public class P73 {

	public static void main(String[] args) {
		int a = 1000;
		String srt = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("명령어를 입력 하시오(q,i,d,s)");
		String cmd = sc.next();
		System.out.printf("%s를 입력 했습니다.", cmd);
		sc.close();
	}

}
