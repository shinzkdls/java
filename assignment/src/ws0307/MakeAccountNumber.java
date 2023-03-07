package ws0307;

import java.util.Calendar;
import java.util.Random;

public class MakeAccountNumber {
	public static String makeAccNum() {
		String accNum = "";
		Calendar cal = Calendar.getInstance();
		accNum = "" + cal.get(Calendar.YEAR) + (cal.get(Calendar.MONTH) + 1) + cal.get(Calendar.DAY_OF_MONTH)
				+ (new Random().nextInt(9000) + 1000);
		return accNum;
	}
}
