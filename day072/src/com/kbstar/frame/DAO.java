package com.kbstar.frame;

public interface DAO<K, V, A> { // <K, V> => 제네릭 Key와 Value
	public void insert(V v);

	public void delete(K k);

	public void update(V v);
}
