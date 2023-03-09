package ws0309;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lotto {
	private Set<Integer> winningNum = new HashSet<Integer>();
	private double prizeMoney;

	public Set<Integer> getSet() {
		return winningNum;
	}

	public double getPrizeMoney() {
		return prizeMoney;
	}

	public Lotto() {
		this.makeWinningNumberMoney();
	}

	public void makeWinningNumberMoney() {
		this.prizeMoney = new Random().nextInt(2000000000) + 1;
		while (this.winningNum.size() < 3) {
			winningNum.add(new Random().nextInt(25) + 1);
		}
	}

	public int checkRanking(ArrayList<Integer> mynum) {
		int grade = 4;
		for (int i = 0; i < mynum.size(); i++) {
			if (winningNum.contains(mynum.get(i)))
				grade--;
		}
		return grade;
	}

	public double prizeMoney(int grade) {
		double rate = grade == 1 ? 0.6 : grade == 2 ? 0.3 : grade == 3 ? 0.1 : 0.0;
		return this.prizeMoney * rate;
	}

}
