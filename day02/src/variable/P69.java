package variable;

public class P69 {

	public static void main(String[] args) {
		String str = "abcdef";
		str = str.toUpperCase();
		System.out.println(str);

		String str2 = str.replace('A', 'Z');
		System.out.println(str2);

		int lng = str.length();
		System.out.println(lng);

		int t = str.indexOf('B');
		System.out.println(t);

		char c = str.charAt(4);
		System.out.println(c);

		String str3 = str.substring(1, 4);
		System.out.println(str3);

		String email = "shinzkdls@gmail.com";

		String id = email.substring(0, 10);
		String domain = email.substring(10, 15);
		System.out.printf("%s , %s", id, domain);
	}
}
