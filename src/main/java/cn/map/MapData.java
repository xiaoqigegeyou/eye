package cn.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cn.pojo.MapPO;
import cn.until.DateFormat;

@Component
public class MapData {
	@Autowired
	private GetMap getMap;

	public MapPO mapAnalysis(JsonArray array) {
		JsonObject object = array.get(0).getAsJsonObject();

		MapPO map = new MapPO();
		map.setMap_node(object.get("nodeHttpAddress").getAsString());
		map.setStart_time(DateFormat.toDate(object.get("startTime").getAsString()));
		map.setFinished_time(DateFormat.toDate(object.get("finishTime").getAsString()));
		map.setElapsed_time(Float.valueOf(object.get("elapsedTime").getAsString()));
		map.setState(object.get("state").getAsString());

		return map;
	}
}
