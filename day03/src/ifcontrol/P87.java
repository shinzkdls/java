package ifcontrol;

public class P87 {

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

		grade = sum >= 90 ? "VIP" : (sum >= 80 ? "GOLD" : (sum >= 70 ? "SILVER" : (sum >= 60 ? "BRONZE" : "NORMAL")));

		if (sum >= 90) {
			grade = "VIP";
		} else if (sum >= 80) {
			grade = "GOLD";
		} else if (sum >= 70) {
			grade = "SILVER";
		} else if (sum >= 60) {
			grade = "BRONZE";
		} else {
			grade = "NORMAL";
		}

		if (grade.equals("VIP")) {
			System.out.println("VIP 혜택....");
			// return;
		}

		System.out.printf("%s, %s, %4.2f\n", grade, gender, sum);

		System.out.println("End....");
	}

}
