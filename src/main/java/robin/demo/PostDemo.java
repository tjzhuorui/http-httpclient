package robin.demo;

import java.util.HashMap;
import java.util.Map;

import robin.http.util.HttpRequest;

public class PostDemo {
	public static void main(String[] args) {
		String url = "http://localhost:9876/query";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("username", "robin");
		paramMap.put("password", "handsome");
		try {
			String res = HttpRequest.post(url, paramMap);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
