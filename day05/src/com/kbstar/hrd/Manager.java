package com.kbstar.hrd;

public class Manager {
	private String id;
	private String name;
	private int salary;
	private int bonus;

	public Manager() {
	}

	public Manager(String id, String name, int salary, int bonus) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.bonus = bonus;
	}

	// getter and setter
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public int getSalary() {
		return this.salary;
	}

	public int getBonus() {
		return this.bonus;
	}

	public double getTax() {
		double result = 0.0;
		result = (this.salary + this.bonus) * 0.17;
		return result;
	}

	public int getAnnSalary() {
		int result = 0;
		result = (this.salary + this.bonus) * 12;
		return result;
	}

	public double getAnnTax() {
		double result = 0.0;
		result = this.getAnnSalary() * 0.17;
		return result;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", salary=" + salary + ", bonus=" + bonus + "]";
	}

}
