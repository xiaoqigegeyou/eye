package cn.node;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cn.until.CONST;
import cn.until.http.JsonHttp;


@Component
public class Getnode {
	@Autowired
	private JsonHttp getHtmlSource;
	
	public JsonArray getNodeDataSourceByFile(String file) {
		InputStream is =Getnode.class.getResourceAsStream(file); 
		if(is==null) System.out.println("yes");
        String json;   
        JsonArray array = null;
        try {    
            json = IOUtils.toString(is);    
            JsonParser jsonParser = new JsonParser();
            JsonObject object = (JsonObject) jsonParser.parse(json); // 创建JsonObject对象
     		object = (JsonObject) object.get("nodes");
     		array = object.get("node").getAsJsonArray(); // 获得原始数据的JSON数组
    		System.out.println(array.size());
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
		return array;
	}
	
	
	//从http中获取
		public JsonArray getApplicationDataSource() {
			JsonObject object = getHtmlSource.getJson("http://kj-gpu-master1.bigdata.com:8088/ws/v1/cluster/nodes");
			//JsonObject object = getHtmlSource.getJson(CONST.HTTP + CONST.MASTER_DOMAIN + CONST.APPLICATION_URL_END);//使用HTTP接口获得原始数据
			object = (JsonObject) object.get("nodes");
			JsonArray array = object.get("node").getAsJsonArray(); // 获得原始数据的JSON数组
			return array;
		}
}
