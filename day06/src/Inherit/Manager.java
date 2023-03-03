package Inherit;

public class Manager extends Employee { // extends 상속받겠다는 키워드
	private double bonus;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String id, String name, double salary) {
		super(id, name, salary);
		// TODO Auto-generated constructor stub
	}

	public Manager(String id, String name, double salary, double bonus) {
		super(id, name, salary);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	// 함수의 재정의(overriding)
	@Override // 어노테이션
	public double getAnnSalary() {
		double result = 0.0;
		result = (this.getSalary() + this.bonus) * 12;
		return result;
	}

	@Override
	public String toString() {
		return super.toString() + " " + bonus;
	}

}
