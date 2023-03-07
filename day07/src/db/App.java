package db;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		DAO dao = new MariaDBDAO();// 인터페이스인 DAO에 실제 구현객체인 OracleDAO 또는 MariaDBDAO를 넣는다는 개념
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Input command(q, i, d, u)");
			String cmd = sc.next();
			if (cmd.equals("q")) {
				System.out.println("Bye");
				break;
			} else if (cmd.equals("i")) {
				System.out.println("Input ID...");
				String id = sc.next();
				System.out.println("Input PWD...");
				String pw = sc.next();
				System.out.println("Input NAME...");
				String name = sc.next();
				UserDTO user = new UserDTO(id, pw, name);
				dao.insert(user); // 인터페이스인 DAO는 오브젝트를 파라미터값으로 받기때문에 모든타입의 객체를 넣을 수 있음
			} else if (cmd.equals("d")) {
				System.out.println("Input ID...");
				String id = sc.next();
				dao.delete(id); // 인터페이스인 DAO는 오브젝트를 파라미터값으로 받기때문에 모든타입의 객체를 넣을 수 있음
			} else if (cmd.equals("u")) {
				System.out.println("Input ID...");
				String id = sc.next();
				System.out.println("Input PWD...");
				String pw = sc.next();
				System.out.println("Input NAME...");
				String name = sc.next();
				UserDTO user = new UserDTO(id, pw, name);
				dao.update(user); // 인터페이스인 DAO는 오브젝트를 파라미터값으로 받기때문에 모든타입의 객체를 넣을 수 있음
			}
		}
		sc.close();

	}

}
