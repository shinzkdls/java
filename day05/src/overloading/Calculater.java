package overloading;

public class Calculater {
	public int sum(int a, int b) {
		int result = 0;
		result = a + b;
		return result;
	}

	public int sum(int a, int b, int c) {
		int result = 0;
		result = a + b + c;
		return result;
	}

	public int sum(int a, int b, int c, int d) {
		int result = 0;
		result = a + b + c + d;
		return result;
	}

}
