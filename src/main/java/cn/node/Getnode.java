package cn.node;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Component
public class Getnode {
	
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
}
