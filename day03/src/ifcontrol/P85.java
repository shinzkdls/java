package ifcontrol;

public class P85 {

	public static void main(String[] args) {
		String grade = "W";
		String gender = "M";
		double sum = 80.0;

		System.out.println("Start....");

		if (gender.equals("M")) {
			System.out.println("Male....");
		} else {
			System.out.println("Female....");
		}

		if (sum >= 90.0) {
			grade = "VIP";
		} else if (sum >= 70.0) {
			grade = "GOLD";
		} else {
			grade = "SILVER";
		}

		if (grade.equals("VIP")) {
			System.out.println("VIP 혜택....");
			// return;
		}

		System.out.printf("%s, %s, %4.2f\n", grade, gender, sum);

		System.out.println("End....");
	}

}
