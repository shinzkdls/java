package board;

public class Service {

	DAO dao;

	public Service() {
		dao = new DAO();
	} // 서비스 클래스가 생성자에 의해 만들어질때 DB에 접근할 수 있는 DAO를 초기화 시킴

	public void register(String str) {
		// Security or Log
		dao.insert(str);
	}

	public void remove(int num) {
		// Security or Log
		dao.delete(num);
	}

	public void modify(int num, String str) {
		dao.update(num, str);
	}

	public String get(int num) {
		return dao.select(num);
	}
}
