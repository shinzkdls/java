package ifcontrole;

public class Ws {

	public static void main(String[] args) {
		int sum3 = 0, sum4 = 0, sum7 = 0;
		double avg3 = 0, avg4 = 0, avg7 = 0;
		for (int i = 1; i < 101; i++) {
			if (i % 3 == 0) {
				sum3 += i;
				avg3++;
			}
			if (i % 4 == 0) {
				sum4 += i;
				avg4++;
			}
			if (i % 7 == 0) {
				sum7 += i;
				avg7++;
			}
		}

		avg3 = sum3 / avg3;
		avg4 = sum4 / avg4;
		avg7 = sum7 / avg7;

		System.out.println("3의 배수 합: " + sum3 + " 평균: " + avg3);
		System.out.println("4의 배수 합: " + sum4 + " 평균: " + avg4);
		System.out.println("7의 배수 합: " + sum7 + " 평균: " + avg7);
	}

}
