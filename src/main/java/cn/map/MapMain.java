package cn.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;

import cn.pojo.MapPO;
import cn.service.MapInfoService;

@Component
public class MapMain {
	@Autowired
	private GetMap getMap;
	@Autowired
	private MapData mapData;
	@Autowired
	private MapInfoService mapInfoService;

	public MapPO mapRun(String jobId, String step) {
		MapPO map = new MapPO();
		String taskId = getMap.getMapDataById(jobId);
		JsonArray array = getMap.getMapAttemptById(jobId, taskId);

		map = mapData.mapAnalysis(array);
		map.setJob_info_id(jobId);
		map.setTask_name(step);
		map.setTask_id(taskId);

		// mapInfoService.insertMap(map);
		return map;
	}
}
