package set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetTest1 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		// 1~10까지 숫자를 10개 입력 하세요
//		for (int i = 0; i < 10; i++) {
//			set.add(new Random().nextInt(10) + 1);
//		}

		while (set.size() < 10) {
			set.add(new Random().nextInt(10) + 1);
		}

		System.out.println(set.size());
		System.out.println("=================");

		for (int data : set) {
			System.out.println(data);
		}
	}

}
