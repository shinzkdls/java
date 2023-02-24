package ifcontrol;

public class P84 {

	public static void main(String[] args) {
		String grade = "W";
		String gender = "M";
		double sum = 90.0;

		System.out.println("Start....");

		if (gender.equals("M")) {
			System.out.println("Male....");
		} else {
			System.out.println("Female....");
		}

		if (sum >= 90) {
			grade = gender + "VIP";
		} else if (sum >= 80) {
			grade = gender + "GOLD";
		} else {
			grade = gender + "NORMAL";
		}

		switch (grade) {
		case "FVIP":
		case "MVIP":
			sum += 100;
			break; ////// 브레이크가없다면 vip들은 100도 받고 90도 받고 10도 받고
		case "FGOLD":
		case "MGOLD":
			sum += 90;
			break; ////// 브레이크가없다면 gold들은 90도 받고 10도 받고
		default:
			sum += 10;
			break;
		}

		System.out.printf("%s, %s, %4.2f\n", grade, gender, sum);

		System.out.println("End....");
	}

}
