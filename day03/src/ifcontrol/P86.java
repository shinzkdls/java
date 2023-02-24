package ifcontrol;

public class P86 {

	public static void main(String[] args) {
		String grade = "W";
		String gender = "M";
		double sum = 80.0;

		System.out.println("Start....");

		System.out.println(gender.equals("M") ? "Male...." : "Female....");

		grade = sum >= 90.0 ? "VIP" : (sum >= 70.0 ? "GOLD" : "SILVER");

		if (grade.equals("VIP")) {
			System.out.println("VIP 혜택....");
			// return;
		}

		System.out.printf("%s, %s, %4.2f\n", grade, gender, sum);

		System.out.println("End....");
	}

}
