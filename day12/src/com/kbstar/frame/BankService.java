package com.kbstar.frame;

import java.util.List;

/**
 * 23.3.10
 * 
 * @author mcssss
 *
 * @param <V1> UserDTO
 * @param <V2> AccountDTO
 * @param <V3> TransactionDTO
 * @param <K>  String id
 * @param <P>  String pwd
 */

public interface BankService<V1, V2, V3, K, P> {
	public void register(V1 v) throws Exception;

	public V1 login(K k, P p) throws Exception;

	public V1 getUserInfo(K k) throws Exception;

	public void makeAccount(K k, double money) throws Exception;

	public List<V2> getAllAccount(K k) throws Exception;

	public List<V3> getAllTransaction(String acc) throws Exception;

	public void transaction(String sendAcc, String receiveAcc, double balance, String desc) throws Exception;
}
