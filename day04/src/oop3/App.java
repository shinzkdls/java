package oop3;

public class App {

	public static void main(String[] args) {
		Car car = new Car("C1", "red", 1000, 50);
		System.out.println(car.toString());

		car.go(5);
		car.setCfsize(0);
		car.setCfsize(51);
		car.setCfsize(25);
		car.go(0);
		car.go(100);
		car.go(200);
		System.out.println(car.toString());

	}

}
