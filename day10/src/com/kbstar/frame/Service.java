package com.kbstar.frame;

public interface Service<K, V> { // <K, V> => 제네릭 Key와 Value
	public void register(V v) throws Exception;

	public void remove(K k) throws Exception;

	public void modify(V v) throws Exception;
}
