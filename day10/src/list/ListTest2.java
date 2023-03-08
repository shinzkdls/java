package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListTest2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		// 1~10 까지의 숫자로 20개 입력 한다.

		while (list.size() < 20) {
			list.add(new Random().nextInt(10) + 1);
		}

		System.out.println("====================");
		System.out.println(list.size());

		for (int data : list) {
			System.out.println(data);
		}

	}

}
