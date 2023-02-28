package ws0228;

public class Manager {
	private String id;
	private String name;
	private int salary;
	private int bonus;

	public Manager() {
		this.id = "temp0001";
		this.name = "temp";
		this.salary = 100000000;
		this.bonus = 1000000;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public int getSalary() {
		return salary;
	}

	public int getBonus() {
		return bonus;
	}

	public Manager(String id, String name, int salary, int bonus) {
		this.id = id;
		this.name = name;
		if (salary < 0) {
			this.salary = 0;
		} else {
			this.salary = salary;
		}
		if (bonus < 0) {
			this.bonus = 0;
		} else {
			this.bonus = bonus;
		}

	}

	public Manager(String name, int salary, int bonus) {
		this("10000", name, salary, bonus);
	}

	public int getAnnSalary() {
		return this.salary * 12 + bonus;
	}

	public double getTax() {
		return this.getAnnSalary() * 0.175;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", salary=" + salary + ", bonus=" + bonus + "]";
	}

}
