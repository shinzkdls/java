package ws0307;

import java.util.Scanner;

public class App {
	// 계좌 생성
	// 계좌 정보 조회
	// 계좌 입금
	// 계좌 출금
	public static void main(String[] args) {
		Account acc = null;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Input command(q, o, c, d, w)");
			String cmd = sc.next();
			if (cmd.equals("q")) {
				System.out.println("Bye");
				break;
			}

			else if (cmd.equals("o")) {
				System.out.println("Input Account Name..");
				String name = sc.next();
				System.out.println("Input Account Holder..");
				String holder = sc.next();
				System.out.println("Input Account Balance..");
				double balance = Double.parseDouble(sc.next());
				try {
					acc = new Account(name, holder, balance);
					System.out.println(acc.toString());
				} catch (NegativeNumberException e) {
					System.out.println(e.getMessage());
				}
			}

			else if (cmd.equals("c")) {
				try {
					System.out.println(acc.toString());
				} catch (NullPointerException e) {
					System.out.println("계좌를 생성해주세요");
				}
			}

			else if (cmd.equals("d")) {
				System.out.println("Input Deposit Money..");
				double money = Double.parseDouble(sc.next());
				try {
					acc.deposit(money);
				} catch (NegativeNumberException e) {
					System.out.println(e.getMessage());
				} catch (NullPointerException e) {
					System.out.println("계좌를 생성해주세요");
				}
			}

			else if (cmd.equals("w")) {
				System.out.println("Input Witdraw Money..");
				double money = Double.parseDouble(sc.next());
				try {
					acc.withdraw(money);
				} catch (NegativeNumberException e) {
					System.out.println(e.getMessage());
				} catch (insufficientbalanceException e) {
					System.out.println(e.getMessage());
				} catch (NullPointerException e) {
					System.out.println("계좌를 생성해주세요");
				}
			}
		}
		sc.close();
	}

}
