package aggregation;

public class Car {
	public String name;
	public String color;
	public int size;

	// 생성자. (constructor);
	public Car() { // Default Constructor는 아무 생성자가 없을때만 기본으로 존재, argument가 포함된 생성자를 선언할 경우 지원하지않음
		this.name = "k1";
		this.color = "red";
		this.size = 1000;
	}

	// 생성자. (constructor); => 생성자 이름은 중복가능
	public Car(String name, String color, int size) {
		this.name = name;
		this.color = color;
		this.size = size;
	}

	public void go() {
//		System.out.println(this.name + " Go Car..");
		System.out.printf("%s, %s go Car..\n", this.name, this.color);
	}

	public void stop() {
//		System.out.println(this.name + " Stop Car..");
		System.out.printf("%s, %s Stop Car..\n", this.name, this.color);
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", size=" + size + "]";
	}

}
