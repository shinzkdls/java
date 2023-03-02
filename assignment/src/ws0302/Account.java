package ws0302;

public class Account {
	private String accNum;
	private String accName;
	private double balance;
	private double rate;
	private String grade;

	public Account() {
		this.accNum = MakeAccountNumber.makeAccNum();
	}// MakeAccountNumber클래스는 static으로 만들어져서 객체의 생성없이 기능만 바로 사용 가능함

	public Account(String accName, double balance, double rate) {
		this();
		this.accName = accName;
		this.balance = balance;
		this.rate = rate;
	}

	public Account(String accName, double balance, double rate, String grade) {
		this(accName, balance, rate);
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", accName=" + accName + ", balance=" + balance + ", rate=" + rate
				+ ", grade=" + grade + "]";
	}

	public String getAccNum() {
		return this.accNum;
	}

	public String getGrade() {
		return this.grade;
	}

	public double getBalance() {
		return this.balance;
	}

	public void withdraw(double money) {
		if (money <= 0) {
			System.out.println("출금 금액을 확인 하세요.");
			return;
		}
		if (money > this.balance) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		this.balance -= money;
	}

	public void deposit(double money) {
		if (money <= 0) {
			System.out.println("입금 금액을 확인 하세요.");
			return;
		}
		this.balance += money;
	}

	public double getInterest() {
		double result = 0.0;
		result = this.balance * this.rate / 100;
		return result;
	}

}
