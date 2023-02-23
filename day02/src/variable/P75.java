package variable;

public class P75 {

	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		a++;
		++b;
		System.out.printf("%d , %d\n", a, b);

		int result = ++a + b++;
		System.out.printf("%d , %d\n", a, b);
		System.out.println(result);

		System.out.println(5 >= 3);

		int aa = 10;
		int bb = 10;
		System.out.println(aa++ >= 10 || bb++ >= 10); // |을 하나만 쓰면 두가지 조건 모두 탐색, ||으로 두개쓰면 앞조건맞을때 넘어감
		System.out.printf("%d , %d\n", aa, bb);
	}

}
