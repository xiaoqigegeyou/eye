
package cn.until.http;

import java.io.File;
import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * 
 * @ClassName:  GetHtmlSource  
 * <p>HTTP请求获取数据</p>
 * @author 崔安兵
 * 2019年9月27日
 *
 */
@Component
public class JsonHttp {

	@Autowired
	private JsonParser jsonParser;
	
	
	@SuppressWarnings("unused")
	@Autowired
	private  HttpClientUtil httpClientUtil;
	/**
	 * <p>通过http请求获取源代码</p>
	 * 
	 * */
	public JsonObject getJson(String url) {
		String body = null;
		JsonObject object = null;
		try {
			body = HttpClientUtil.doGetForUrl(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		object = (JsonObject) jsonParser.parse(body); // 创建JsonObject对象
		return object;
	}
	
	public String getXML(String url) {
		String body = null;
		try {
			Response document = Jsoup.connect(url)
					.header("Accept", "*/*")
					.header("Accept-Encoding", "gzip, deflate")
					.header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
					.header("Content-Type", "application/xml;charset=UTF-8")
					.header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
					.timeout(10000).ignoreContentType(true).execute();
			body = document.body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}
	
	/**
	 * 
	 * @Title: getJsonInFile   
	 *  <p>   </p>
	 * @param file  文件名，包含文件路径
	 * @param code  编码格式
	 * @param baseUri 该参数用于解决文件中URLs是相对路径的问题。如果不需要可以传入一个空的字符串。
	 * @return String     
	 * @throws
	 */
	public Document getJsonInFile(String file,String code,String baseUri) {
		
		File input = new File(file);
		Document doc = null;
		try {
			doc = Jsoup.parse(input, code, baseUri);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	/**
	 * 读取一个URL
	 * @param url
	 * @return
	 */
	public Document readByUrl(String url) throws IOException{
		Document document = null;
		document = Jsoup.connect(url).timeout(50000).post();
		return document;
	}
}
