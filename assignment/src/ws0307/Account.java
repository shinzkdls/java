package ws0307;

public class Account {
	private String accNo;
	private String name;
	private String accHolder;
	private double balance;

	// Constructor - 음수 예외 상황
	public Account() {
		this.accNo = MakeAccountNumber.makeAccNum();
	}

	public Account(String name, String accHolder, double balance) throws NegativeNumberException {
		this();
		if (balance < 0.0) {
			throw new NegativeNumberException("음수입력에러");
		}
		this.name = name;
		this.accHolder = accHolder;
		this.balance = balance;
	}

	// 계좌 정보 조회
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", name=" + name + ", accHolder=" + accHolder + ", balance=" + balance + "]";
	}

	// 잔액 조회
	public double getBalance() {
		return balance;
	}

	// 입금 - 음수 예외 상황
	public void deposit(double money) throws NegativeNumberException {
		if (money <= 0.0) {
			throw new NegativeNumberException("음수입력에러");
		}
		this.balance += money;
	}

	// 출금 - 잔액 부족 예외 상황, 음수 예외 상황
	public void withdraw(double money) throws NegativeNumberException, insufficientbalanceException {
		if (money <= 0.0) {
			throw new NegativeNumberException("음수입력에러");
		}
		if (money > this.balance) {
			throw new insufficientbalanceException("잔액부족에러");
		}
		this.balance -= money;
	}
}
