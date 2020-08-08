package cn.cluster;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cn.application.Getappliction;
import cn.until.http.JsonHttp;
@Component
public class Getcluster {

	@Autowired
	private JsonHttp jsonHttp;
	
	
	//从文件获取
	public JsonObject getClusterDataSourceByFile(String file) {
		InputStream is =Getcluster.class.getResourceAsStream(file); 
		if(is==null) System.out.println("yes");
        String json;   
        JsonArray array = null;
        JsonObject object=null;
        try {    
            json = IOUtils.toString(is);    
            JsonParser jsonParser = new JsonParser();
            object = (JsonObject) jsonParser.parse(json); // 创建JsonObject对象
     		object = (JsonObject) object.get("clusterMetrics");
     		//array.add(object);
     		//array = object.getAsJsonArray(); // 获得原始数据的JSON数组
    		//System.out.println(array.size());
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
		return object;
	}
	
	
	
	//从http中获取
	public JsonObject getClusterDataSource() {
		
		//JsonObject object = jsonHttp.getJson(CONST.HTTP + CONST.MASTER_DOMAIN + CONST.APPLICATION_URL_END);//使用HTTP接口获得原始数据
		JsonObject object = jsonHttp.getJson("http://kj-gpu-master1.bigdata.com:8088/ws/v1/cluster/metrics");
		object = (JsonObject) object.get("clusterMetrics");
		
		return object;
	}
}
