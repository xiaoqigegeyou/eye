package cn.application;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;

import cn.pojo.job;
import cn.service.JobInfoService;

@Component
public class applicationMain {
	@Autowired
	private Getappliction getappliction;
	@Autowired
	private applicationData applicationData;
	@Autowired
	private JobInfoService jobInfoService;
	
	@Scheduled(fixedDelay = 30000)
	//@Scheduled(cron="* 0/10 * * * ?")    //每10分钟调度一次 [秒] [分] [小时] [日] [月] [周] [年]
	public void run() {
	//	JsonArray arry=getappliction.getApplicationDataSource();
		JsonArray arry=getappliction.getjobApplicationDataSourceByFile("apps.txt");
		Map<String, List<job>> jobAnalysisResult = applicationData.jobAnalysis(arry);
		List<job> runingJobList = jobAnalysisResult.get("runing");//正在运行的任务列表
		List<job> finishedJobList = jobAnalysisResult.get("finished");//已经完成的任务列表
		jobInfoService.insert_job_info_runing(runingJobList);
		jobInfoService.insert_job_info_today(finishedJobList);
		
		
	}
	
	
}
