package robin.http.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HttpRequest {
	public static String post(String url, Map<String, String> postMap) throws Exception {
		// 创建客户端对象
		HttpClient hc = new DefaultHttpClient();
		// 创建post请求对象
		HttpPost httpPost = new HttpPost(url);
		// 封装form表单提交的数据
		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		for (Map.Entry<String, String> entry : postMap.entrySet())
			parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		// 数据已经封装在集合中,将集合传给实体对象
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters, "utf-8");
		// 设置post请求对象的实体,即将提交的数据封装到post请求的输出流中
		httpPost.setEntity(entity);
		// 使用客户端发送post请求
		HttpResponse hr = hc.execute(httpPost);
		if (hr.getStatusLine().getStatusCode() == 200) {
			InputStream is = hr.getEntity().getContent();
			String text = Utils.getTextFromStream(is);
			return text;
		}
		return null;
	}

	public static String get(String url) throws Exception {
		// 创建HttpClient对象
		HttpClient hc = new DefaultHttpClient();
		// 创建HttpGet对象,构造方法的参数为要提交的网址
		HttpGet hg = new HttpGet(url);
		// 使用客户端对象,把get请求对象发送出去
		HttpResponse hr = hc.execute(hg);
		// 拿到相应头中的状态行
		// 判断相应码是否为200
		if (hr.getStatusLine().getStatusCode() == 200) {
			// 拿到相应头实体
			// 拿到实体中的内容，即服务器返回的输入流
			InputStream is = hr.getEntity().getContent();
			String text = Utils.getTextFromStream(is);
			return text;
		}
		return null;
	}
}
