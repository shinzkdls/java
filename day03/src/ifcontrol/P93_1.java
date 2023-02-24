package ifcontrol;

import java.util.Scanner;

public class P93_1 {

	public static void main(String[] args) {
		// 숫자를 4개의 2자리수를 입력 받는다.
		// 평균과 합계를 구합니다.

		// 평균이 90이상이면 A
		// 평균이 80이상이면 B
		// 평균이 70이상이면 C
		// 평균이 60이상이면 D
		// 60미만이면 F

		// 합계, 평균, 학점을 출력 하시오
		int sum = 0;
		int score[] = new int[4];
		int i = 0;
		Scanner sc = new Scanner(System.in);
		while (i < 4) {
			System.out.println(i + 1 + "번째 수를 입력하세요.(10~99)");
			score[i] = sc.nextInt();
			if (score[i] < 10 || score[i] > 99) {
				System.out.println("잘못된 범위입니다.");
				continue;
			} else {
				sum = sum + score[i];
				i++;
			}
		}
		String grade = sum / 4 >= 90 ? "A" : (sum / 4 >= 80 ? "B" : sum / 4 >= 70 ? "C" : sum / 4 >= 60 ? "D" : "F");
		System.out.printf("합계 : %d, 평균 : %4.2f, 학점 : %s", sum, (double) sum / 4, grade);
		sc.close();
	}

}
