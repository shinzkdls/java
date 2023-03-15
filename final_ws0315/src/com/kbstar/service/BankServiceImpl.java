package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.AccountDaoImpl;
import com.kbstar.dao.BankUserDaoImpl;
import com.kbstar.dao.TransactionDaoImpl;
import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.BankUserDTO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.BankService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeNumber;

public class BankServiceImpl implements BankService<BankUserDTO, AccountDTO, TransactionDTO, String, String> {

	DAO<String, String, BankUserDTO> bankUserDao;
	DAO<String, String, AccountDTO> accountDao;
	DAO<String, String, TransactionDTO> tranDao;

	public BankServiceImpl() {
		bankUserDao = new BankUserDaoImpl();
		accountDao = new AccountDaoImpl();
		tranDao = new TransactionDaoImpl();
	}

	@Override
	public void register(BankUserDTO v) throws Exception {
		try {
			bankUserDao.insert(v);
		} catch (Exception e) {
			throw new Exception("등록 오류");
		}
	}

	@Override
	public BankUserDTO login(String k, String p) throws Exception {
		BankUserDTO bankUser = null;
		bankUser = bankUserDao.select(k);
		if (bankUser != null) {
			if (bankUser.getPwd().equals(p)) {
				System.out.println("OK");
			} else {
				throw new Exception("로그인 실패...");
			}
		} else {
			throw new Exception("로그인 실패...");
		}
		return bankUser;
	}

	@Override
	public void makeAccount(String k, double money) throws Exception {
		String accno = MakeNumber.makeAccNum();
		AccountDTO acc = new AccountDTO(accno, money, k);
		try {
			accountDao.insert(acc);
		} catch (Exception e) {
			throw new Exception("등록 오류");
		}
	}

	@Override
	public List<AccountDTO> getAllAccount(String k) throws Exception {
		List<AccountDTO> list = null;
		list = accountDao.search(k);
		return list;
	}

	@Override
	public List<TransactionDTO> getAllTransaction(String acc) throws Exception {
		List<TransactionDTO> list = null;
		list = tranDao.search(acc);
		return list;
	}

	@Override
	public void transaction(String sendAcc, String receiveAcc, double balance, String desc) throws Exception {
		// 계좌 정보 수정
		// 계좌 잔액 정보를 조회하고 잔액에서 이체 하는 금액을 차감한 잔액으로 수정
		AccountDTO acc = null;
		acc = accountDao.select(sendAcc);
		double abalance = acc.getBalance() - balance;
		acc.setBalance(abalance);
		accountDao.update(acc);
		// 거래 내역 추가
		TransactionDTO trn = new TransactionDTO(MakeNumber.makeTranNum(), null, sendAcc, balance, "O", desc);
		tranDao.insert(trn);

	}

}
