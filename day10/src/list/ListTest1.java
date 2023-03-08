package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListTest1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new Random().nextInt(10) + 1);
		}
		list.add(0, 100);
		list.remove(0);
		for (int data : list) {
			System.out.println(data);
		}
	}

}
