package array;

public class P103 {

	public static void main(String[] args) {
		int a = 100;
		int arr[] = new int[3];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		System.out.println(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);

		}

		System.out.println("Type 2");
		for (int data : arr) {
			System.out.println(data);
		}
	}

}
