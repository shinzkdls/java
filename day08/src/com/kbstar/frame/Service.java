package com.kbstar.frame;

public interface Service<K, V> { // <K, V> => 제네릭 Key와 Value
	public void register(V v);

	public void remove(K k);

	public void modify(V v);
}
