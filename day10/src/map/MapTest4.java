package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.kbstar.dto.UserDTO;

public class MapTest4 {

	public static void main(String[] args) {
		Map<String, UserDTO> db = new HashMap<String, UserDTO>();
		db.put("id01", new UserDTO("id01", "pwd01", "james1"));
		db.put("id02", new UserDTO("id02", "pwd02", "james2"));
		db.put("id03", new UserDTO("id03", "pwd03", "james3"));

		UserDTO u = db.get("id02");
		System.out.println(u);

		System.out.println("=====================================");

		UserDTO uu = new UserDTO("id02", "0000", "james2");
		db.put(uu.getId(), uu);

		Collection<UserDTO> col = db.values();
		for (UserDTO data : col) {
			System.out.println(data);
		}

		for (Entry<String, UserDTO> data : db.entrySet()) {
			System.out.println(data);
		}

	}

}
