package com.kbstar.app;

import java.util.List;
import java.util.Scanner;

import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.BankUserDTO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.BankService;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.AccountCRUDServiceImpl;
import com.kbstar.service.BankServiceImpl;
import com.kbstar.service.BankUserCRUDServiceImpl;
import com.kbstar.service.TransactionCRUDServiceImpl;

public class App {

	public static void main(String[] args) {

		// register, login, makeAccount, getAllAccount, getAllTransaction, transaction
		// 기능
		BankService<BankUserDTO, AccountDTO, TransactionDTO, String, String> bankService = new BankServiceImpl();
		CRUDService<String, BankUserDTO> bankUserService = new BankUserCRUDServiceImpl();
		CRUDService<String, AccountDTO> accountService = new AccountCRUDServiceImpl();
		CRUDService<String, TransactionDTO> tranService = new TransactionCRUDServiceImpl();

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("----   Bank Program -----");
			System.out.println("Login(l) or Register(r) (q) ...");
			String cmd = sc.next();
			if (cmd.equals("q")) {
				System.out.println("Bye...");

				break;
			} else if (cmd.equals("r")) {
				System.out.println("Register.. ");
				System.out.println("Input ID");
				String id = sc.next();
				System.out.println("Input PWD");
				String pwd = sc.next();
				System.out.println("Input NAME");
				String name = sc.next();
				System.out.println("Input EMAIL");
				String email = sc.next();
				System.out.println("Input CONTACT");
				String contact = sc.next();
				BankUserDTO bankUser = new BankUserDTO(id, pwd, name, email, contact);
				try {
					bankService.register(bankUser);
					System.out.println("환영합니다.");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (cmd.equals("l")) {
				System.out.println("Login.. ");
				System.out.println("ID를 입력 하세요.. ");
				String id = sc.next();
				System.out.println("PWD를 입력 하세요.. ");
				String pwd = sc.next();
				BankUserDTO bankUser = null;
				try {
					bankUser = bankService.login(id, pwd);
					System.out.println("로그인 성공");
					System.out.println("----------------------------");
					while (true) {
						System.out.println("Menu(사용자정보조회(c),계좌생성(m),계좌조회(ai),거래조회(ti),계좌이체(t),나가기(e))...");
						String cmn = sc.next();
						if (cmn.equals("e")) {
							System.out.println("Logout...");
							break;
						} else if (cmn.equals("c")) {
							System.out.println("사용자정보조회...");
							BankUserDTO userinfo = null;
							userinfo = bankUserService.get(bankUser.getId());
							System.out.println(userinfo);
						} else if (cmn.equals("m")) {
							System.out.println("계좌생성");
							AccountDTO acc = null;
							System.out.println("금액을 입력 하세요.. ");
							double balance = Double.parseDouble(sc.next());
							acc = new AccountDTO(null, balance, bankUser.getId());
							accountService.register(acc);
							System.out.println("계좌생성완료");
						} else if (cmn.equals("ai")) {
							System.out.println("계좌조회");
							List<AccountDTO> list = null;
							list = bankService.getAllAccount(bankUser.getId());
							for (AccountDTO acc : list) {
								System.out.println(acc);
							}
						} else if (cmn.equals("ti")) {
							System.out.println("거래내역조회");
							System.out.println("계좌번호입력");
							String accno = sc.next();
							List<TransactionDTO> list = null;
							list = bankService.getAllTransaction(accno);
							for (TransactionDTO trn : list) {
								System.out.println(trn);
							}
						} else if (cmn.equals("t")) {
							System.out.println("계좌이체");
							System.out.println("보내는 계좌 입력");
							String sendAcc = sc.next();
							System.out.println("받는 계좌 입력");
							String reciveAcc = sc.next();
							System.out.println("보낼 금액 입력");
							double balance = Double.parseDouble(sc.next());
							System.out.println("적요 입력");
							String deac = sc.next();
							bankService.transaction(sendAcc, reciveAcc, balance, deac);
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		sc.close();
	}

}
