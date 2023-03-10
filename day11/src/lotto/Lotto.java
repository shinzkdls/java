package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lotto {
	private Set<Integer> winningNum;
	private double prizeMoney;

	public Lotto() {
		winningNum = new HashSet<Integer>();
	}

	public Set<Integer> getWinningNum() {
		return winningNum;
	}

	public double getPrizeMoney() {
		return prizeMoney;
	}

	public void makeWinningNumberMoney() {
		this.prizeMoney = new Random().nextInt(2000000000) + 1;
		while (this.winningNum.size() < 3) {
			winningNum.add(new Random().nextInt(25) + 1);
		}
		System.out.println(prizeMoney);
		System.out.println(winningNum.toString());
	}

	public int checkRanking(ArrayList<Integer> mynum) throws Exception {
		int grade = 0;
		int cnt = 0;
		for (int num : mynum) {
			for (int wnum : winningNum) {
				if (num == wnum)
					cnt++;
			}
		}
		switch (cnt) {
		case 3:
			grade = 1;
			break;
		case 2:
			grade = 2;
			break;
		case 1:
			grade = 3;
			break;
		default:
			throw new Exception("꽝");
		}
		return grade;
	}

	public double prizeMoney(int grade) {
		double rate = grade == 1 ? 0.6 : grade == 2 ? 0.3 : grade == 3 ? 0.1 : 0.0;
		return this.prizeMoney * rate;
	}
}
