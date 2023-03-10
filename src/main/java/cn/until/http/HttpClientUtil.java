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
	 * Note:??????Json??????
	 * 
	 * @param url URL??????
	 * @return String ??????Json??????????????????
	 * @throws IOException
	 */
	public static String doGetForUrl(String url) throws IOException {
		CloseableHttpClient c = HttpClients.createDefault();// ??????http?????????
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000)// ????????????????????????
				.setConnectionRequestTimeout(10000)// ??????????????????
				.setSocketTimeout(10000)// ?????????????????????
				.setRedirectsEnabled(true).build();// ???????????????????????????
		HttpGet httpGet = new HttpGet(url);// ??????get??????
		httpGet.setHeader("Content-type", "application/json");// ??????application/json?????????
		httpGet.setConfig(requestConfig);// ??????????????????
		return EntityUtils.toString(c.execute(httpGet).getEntity());// ??????get???????????????????????????????????????????????????
	}

}
