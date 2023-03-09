package ws0309;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("1~25 숫자를 3개 입력해주세요");

		while (list.size() < 3) {
			System.out.println(list.size() + 1 + "번째 숫자 입력");
			int a = 0;
			try {
				a = Integer.parseInt(sc.next());
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			if (a < 1 || a > 25) {
				System.out.println("잘못된 범위입니다.");
				continue;
			}
			if (list.contains(a)) {
				System.out.println("이미 입력된 숫자입니다.");
				continue;
			}
			list.add(a);
		}

		Lotto L = new Lotto();
		int grade = L.checkRanking(list);
		double myPrize = Math.round(L.prizeMoney(grade));
		System.out.println("당첨 번호는!!");
		for (int data : L.getSet()) {
			System.out.print(data + " ");
		}
		System.out.println("\n총 당첨 금액은 " + new BigDecimal(L.getPrizeMoney()));
		System.out.println("나의 등수: " + grade + "등 나의 당첨금: " + new BigDecimal(myPrize));

		sc.close();
	}

}
