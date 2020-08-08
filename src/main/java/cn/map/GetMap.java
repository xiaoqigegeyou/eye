package cn.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cn.until.http.JsonHttp;
@Component
public class GetMap {
	@Autowired
	private JsonHttp jsonHttp;

	//从http中获取
	public String  getMapDataById(String jobId) {
			
			JsonObject object = jsonHttp.getJson("http://kj-gpu-manager.bigdata.com:19888/ws/v1/history/mapreduce/jobs/job_"+jobId+"/tasks");
			object = (JsonObject) object.get("tasks");
			JsonArray array = object.get("task").getAsJsonArray();
			JsonObject task = array.get(0).getAsJsonObject();
			String taskId = task.get("id").getAsString();
			
			return taskId;
		}
	
	public JsonArray getMapAttemptById(String jobId, String taskId) {
			
			JsonObject object = jsonHttp.getJson("http://kj-gpu-manager.bigdata.com:19888/ws/v1/history/mapreduce/jobs/job_"+
			jobId+"/tasks/"+taskId+"/attempts");
			object = (JsonObject) object.get("taskAttempts");
			JsonArray attemptArray = object.get("taskAttempt").getAsJsonArray();
			
			return attemptArray;
		}
}