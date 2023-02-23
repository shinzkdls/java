package variable;

public class P64 {

	public static void main(String[] args) {
		int a = 10;
		double d = 10.2345;
		String str1 = "abc"; // 힙영역 스트링풀에 "abc"라는 문자열 생성, 해당주소가 str1에 들어감
		String str2 = "abc"; // 힙영역 스트링풀에 "abc"라는 문자열이 있기때문에 같은 주소가 str2에 들어감
		String str3 = new String("abc"); // 힙영역의 스트링풀이 아닌곳에! 새로운 문자열 "abc"를 넣고 새로운 주소를 str3에 할당
		System.out.printf("%d %4.2f %s\n", a, d, str1);
		if (str1 == str2) { // 주소를 비교하여 같은지 확인
			System.out.println("OK-1");
		}
		if (str1.equals(str2)) { // 주소에 들어있는 값을 비교하여 같은지 확인
			System.out.println("OK-2");
		}
		if (str1 == str3) { // 주소를 비교하여 같은지 확인
			System.out.println("OK-3");
		}
		if (str1.equals(str3)) { // 주소에 들어있는 값을 비교하여 같은지 확인
			System.out.println("OK-4");
		}

		str1 = "def"; // 힙영역 스트링풀에 "def"라는 문자열 생성, 해당주소를 str1의 주소로 변경

	}

}
