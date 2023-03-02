package ws0302;

public class App {

	public static void main(String[] args) {
		Account[] accs = new Account[6];
		accs[0] = new Account("james1", 10000, 0.35, "VIP");
		accs[1] = new Account("james2", 10000, 0.45, "GOLD");
		accs[2] = new Account("james3", 10000, 0.55, "SIVER");
		accs[3] = new Account("james4", 10000, 0.15, "GOLD");
		accs[4] = new Account("james5", 10000, 0.28, "SIVER");
		accs[5] = new Account("james6", 10000, 0.31, "VIP");

		for (Account a : accs) {
			System.out.println(a);
		}

		System.out.println("");

		for (Account a : accs) {
			System.out.println("계좌번호 " + a.getAccNum() + "의 잔액: " + a.getBalance() + ", 이자: "
					+ Math.round(a.getInterest() * 100) / 100.0);
		}

		System.out.println("");

		double sum = 0;
		int cnt = 0;
		for (Account a : accs) {
			if (a.getGrade().equals("VIP")) {
				sum += a.getBalance();
				cnt++;
			}
		}
		double avg = sum / cnt;
		System.out.println("VIP고객들의 잔액 합계: " + sum + ", 평균: " + avg);
	}

}
