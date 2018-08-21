# http-httpclient
基于Apache的httpclient，做二次封装，封装简单的HttpRequest，其中包括get和post方法
详细的使用方法可以见GetDemo和PostDemo。
简单，实用。

将来等我研究好Http协议，再动手，完全自己写一个。

### get
		String url = "http://localhost:9876/query";
		try {
			String res = HttpRequest.get(url);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
   
### post
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
