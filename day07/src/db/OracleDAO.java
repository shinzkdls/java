package db;

public class OracleDAO implements DAO { // implements는 인터페이스인 DAO의 정의된 메소드를 구현하겠다는 의미

	@Override
	public void insert(Object obj) {
		System.out.println(obj);
		System.out.println("Inserted Oracle Database");
	}

	@Override
	public void delete(Object obj) {
		System.out.println(obj);
		System.out.println("Deleted Oracle Database");
	}

	@Override
	public void update(Object obj) {
		System.out.println(obj);
		System.out.println("Updated Oracle Database");
	}

}
