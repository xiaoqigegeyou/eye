package cn.application;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cn.until.http.JsonHttp;

@Component
public class Getappliction {

	@Autowired
	private JsonHttp jsonHttp;

	// 从文件获取
	public JsonArray getjobApplicationDataSourceByFile(String file) {
		InputStream is = Getappliction.class.getResourceAsStream(file);
		if (is == null)
			System.out.println("no");
		String json;
		JsonArray array = null;
		try {
			json = IOUtils.toString(is);
			JsonParser jsonParser = new JsonParser();
			JsonObject object = (JsonObject) jsonParser.parse(json); // 创建JsonObject对象
			object = (JsonObject) object.get("apps");
			array = object.get("app").getAsJsonArray(); // 获得原始数据的JSON数组
			System.out.println(array.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return array;
	}

	// 从http中获取
	public JsonArray getApplicationDataSource() {
/*			http://172.13.31.203:8088 对应的网址 http://kj-gpu-master2.bigdata.com:8088
 * 			http://172.13.31.201:19888 对应的网址 http://kj-gpu-manager.bigdata.com:19888
 * */
		JsonObject object = jsonHttp.getJson("http://kj-gpu-master1.bigdata.com:8088/ws/v1/cluster/apps");
		// JsonObject object = jsonHttp.getJson(CONST.HTTP + CONST.MASTER_DOMAIN +
		// CONST.APPLICATION_URL_END);//使用HTTP接口获得原始数据
		object = (JsonObject) object.get("apps");
		JsonArray array = object.get("app").getAsJsonArray(); // 获得原始数据的JSON数组
		return array;
	}
}
