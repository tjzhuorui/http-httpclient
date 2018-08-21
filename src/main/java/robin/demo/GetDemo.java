package robin.demo;

import robin.http.util.HttpRequest;

public class GetDemo {
	public static void main(String[] args) {
		String url = "http://localhost:9876/query";
		try {
			String res = HttpRequest.get(url);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
