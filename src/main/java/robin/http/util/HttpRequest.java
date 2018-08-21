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
		// �����ͻ��˶���
		HttpClient hc = new DefaultHttpClient();
		// ����post�������
		HttpPost httpPost = new HttpPost(url);
		// ��װform���ύ������
		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		for (Map.Entry<String, String> entry : postMap.entrySet())
			parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		// �����Ѿ���װ�ڼ�����,�����ϴ���ʵ�����
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters, "utf-8");
		// ����post��������ʵ��,�����ύ�����ݷ�װ��post������������
		httpPost.setEntity(entity);
		// ʹ�ÿͻ��˷���post����
		HttpResponse hr = hc.execute(httpPost);
		if (hr.getStatusLine().getStatusCode() == 200) {
			InputStream is = hr.getEntity().getContent();
			String text = Utils.getTextFromStream(is);
			return text;
		}
		return null;
	}

	public static String get(String url) throws Exception {
		// ����HttpClient����
		HttpClient hc = new DefaultHttpClient();
		// ����HttpGet����,���췽���Ĳ���ΪҪ�ύ����ַ
		HttpGet hg = new HttpGet(url);
		// ʹ�ÿͻ��˶���,��get��������ͳ�ȥ
		HttpResponse hr = hc.execute(hg);
		// �õ���Ӧͷ�е�״̬��
		// �ж���Ӧ���Ƿ�Ϊ200
		if (hr.getStatusLine().getStatusCode() == 200) {
			// �õ���Ӧͷʵ��
			// �õ�ʵ���е����ݣ������������ص�������
			InputStream is = hr.getEntity().getContent();
			String text = Utils.getTextFromStream(is);
			return text;
		}
		return null;
	}
}
