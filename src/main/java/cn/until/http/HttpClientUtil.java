package cn.until.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

@Component
public class HttpClientUtil {

	public static String doPostForJson(String url, Map<String, Object> map) {
		CloseableHttpClient c = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000).setConnectionRequestTimeout(10000)
				.setSocketTimeout(10000).setRedirectsEnabled(true).build();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		if (map != null) {
			List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();

			for (String key : map.keySet()) {
				list.add(new BasicNameValuePair(key, map.get(key).toString()));
			}
			try {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
				httpPost.setEntity(entity);
				HttpResponse httpResponse = c.execute(httpPost);

				if (httpResponse != null) {
					String sb = null;
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						sb = EntityUtils.toString(httpResponse.getEntity());
						return sb;
					} else if (httpResponse.getStatusLine().getStatusCode() == 400) {
						sb = "Error Response: " + httpResponse.getStatusLine().toString();
					} else if (httpResponse.getStatusLine().getStatusCode() == 500) {
						sb = "Error Response: " + httpResponse.getStatusLine().toString();
					} else {
						sb = "Error Response: " + httpResponse.getStatusLine().toString();
					}
					return sb;
				} else {
					return "-------";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				return EntityUtils.toString(c.execute(httpPost).getEntity());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "---";
	}

	/**
	 * Note:请求Json数据
	 * 
	 * @param url URL地址
	 * @return String 返回Json的字符串形式
	 * @throws IOException
	 */
	public static String doGetForUrl(String url) throws IOException {
		CloseableHttpClient c = HttpClients.createDefault();// 获得http客户端
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000)// 设置连接超时时间
				.setConnectionRequestTimeout(10000)// 设置请求时间
				.setSocketTimeout(10000)// 设置读写超时间
				.setRedirectsEnabled(true).build();// 设置是否允许重定向
		HttpGet httpGet = new HttpGet(url);// 创建get请求
		httpGet.setHeader("Content-type", "application/json");// 设置application/json响应头
		httpGet.setConfig(requestConfig);// 设置配置信息
		return EntityUtils.toString(c.execute(httpGet).getEntity());// 发送get请求并获得相应实体，以响应内容返回
	}

}
