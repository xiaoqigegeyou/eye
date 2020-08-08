package cn.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;

import cn.map.MapMain;
import cn.pojo.ApplicationPO;
import cn.pojo.MapPO;
import cn.service.JobInfoService;
import cn.service.MapInfoService;

@Component
public class ApplicationMain {
	@Autowired
	private Getappliction getappliction;
	@Autowired
	private ApplicationData applicationData;
	@Autowired
	private JobInfoService jobInfoService;
	@Autowired
	private MapMain mapMain;
	@Autowired
	private MapInfoService mapInfoService;
	
	//@Scheduled(fixedDelay = 30000)
	@Scheduled(cron="30 0/10 * * * ? ")    //每10分钟调度一次 [秒] [分] [小时] [日] [月] [周] [年]
	public void run() {
		
		JsonArray array=getappliction.getApplicationDataSource();
		//JsonArray arry=getappliction.getjobApplicationDataSourceByFile("apps.txt");
		Map<String, List<ApplicationPO>> applicationAnalysisResult = applicationData.applicationAnalysis(array);
		List<ApplicationPO> runingJobList = applicationAnalysisResult.get("runing");//正在运行的任务列表
		List<ApplicationPO> finishedJobList = applicationAnalysisResult.get("finished");//已经完成的任务列表
		jobInfoService.insert_job_info_runing(runingJobList);
		jobInfoService.insert_job_info_today(finishedJobList);
		System.out.println("获取application");
		
		
		
		
		if(finishedJobList!= null && finishedJobList.size() > 0) {
			List<MapPO> mapList =new ArrayList<MapPO>();
			for(ApplicationPO application : finishedJobList) {
				MapPO map =new MapPO();
				map = mapMain.mapRun(application.getJob_id(), application.getStep_id().toString());
				mapList.add(map);
			}
			mapInfoService.insertMap(mapList);
			System.out.println("获取map");
		}
	}
	
	
}
